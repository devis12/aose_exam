:- consult("UnityLogic/KBs/UnityLogicAgentAPI.prolog").

/* Triggered by a drone to sort out the delivery of the package,
    which either has to be assigned to a drone 
        (in case the destination area is equal to the start)
    or it has to be put in the exchange area
*/
add pkg_switch(B) && (\+ belief busy) => [
    act printLog("RAILBOT triggered to work"),
    add_belief(busy),
    cr goTo(B),
    act pickUp(B),
    add_belief(holding(B))
].

/*  Package switch inn the scenario in which the destination is equal to the start area*/
add pkg_switch(B) && ((belief busy), belief(holding(B))) => [
    act printLog("CHECK pkg switch same area"),

    /*Check start and destination of the box*/
    check_artifact_belief(B, start(S)),
    check_artifact_belief(B, destination(D)),
    check_agent_belief(S, area(Start)),
    check_agent_belief(D, area(Dest)),

    /*Start & Destination area are the same: drop down the package where it was*/
    Start = Dest,

    act printLog("pkg switch same area"),

    act (getArea(Dest), DestSame),

    /*trigger a drone to perform ending part of delivery*/
    act (getDrone, Drone),
    (
        not(check_agent_belief(Drone, busy)),
        add_agent_belief(Drone, busy)
    ),
    add_agent_desire(Drone, finish_delivery(B)),

    /*now, you can put down the box and go recharge*/
    act dropDown(DestSame),
    del_belief(holding(B)), 

    add_belief(needRecharge)
].

/*  Package switch inn the scenario in which the destination is equal to the start area*/
add pkg_switch(B) && ((belief busy), belief(holding(B))) => [
    act printLog("CHECK pkg switch diff area"),

    /*Check start and destination of the box*/
    check_artifact_belief(B, start(S)),
    check_artifact_belief(B, destination(D)),
    check_agent_belief(S, area(Start)),
    check_agent_belief(D, area(Dest)),

    /*Start & Destination area are the same: drop down the package where it was*/
    Start \= Dest,
    act printLog("pkg switch different area"),
    
    act (getExchangeArea, Exchange),
    cr goTo(Exchange), 

    /*trigger sorting bot to deliver B to destination exchange area*/
    
    /*now, you can put down the box and go recharge*/
    act dropDown(Exchange),
    del_belief(holding(B)),

    add_belief(needRecharge)
].

/*  need to recharge */
add pkg_switch(_) && ((belief busy), (belief needRecharge)) => [
    
    /*get recharging station*/
    act (getChargingStation, CS),

    /*go to the charging station to rest*/
    cr goTo(CS),

    del_belief(busy),
    del_belief(needRecharge),

    /*time to delete the desire pkg_switch because delivery has been completed*/
    stop
].