:- consult("UnityLogic/KBs/UnityLogicAgentAPI.prolog").

/* Triggered by a drone to sort out the delivery of the package,
    which either has to be assigned to a drone 
        (in case the destination area is equal to the start)
    or it has to be put in the exchange area
*/
add pkg_switch(B) && (\+ belief busy) => [
    act printLog("RAILBOT triggered pkg_switch"),
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

    act (getArea(Dest), DestPlatform),

    /*trigger a drone to perform ending part of delivery*/
    act (getDrone, Drone),
    add_agent_desire(Drone, finish_delivery(B)),

    /*now, you can put down the box and go recharge*/
    act dropDown(DestPlatform),
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
    act (getSortingBot, SortingBot),
    add_agent_desire(SortingBot, sort(B)),

    /*now, you can put down the box and go recharge*/
    act dropDown(Exchange),
    del_belief(holding(B)),

    add_belief(needRecharge)
].

/*  Need to recharge after pkg_switch*/
add pkg_switch(_) && (belief needRecharge) => [
    
    /*get recharging station*/
    act (getChargingStation, CS),

    /*go to the charging station to rest*/
    cr goTo(CS),

    /*wipe out state beliefs*/
    del_belief(busy),
    del_belief(needRecharge),

    /*time to delete the desire pkg_switch because delivery has been completed*/
    stop
].

/*  Triggered by SortingBot so to deliver box B to destination platform*/
add pkg_switch_reverse(B) && (\+ belief busy) => [
    /*Pickup box to deliver*/
    act printLog("RAILBOT triggered pkg_switch_reverse"),
    add_belief(busy),
    cr goTo(B),
    act pickUp(B),

    /*Carry box to destination platform*/
    check_artifact_belief(B, start(S)),
    check_agent_belief(S, area(Start)),
    act (getArea(Start), StartPlatform),
    cr goTo(StartPlatform),
    
    
    /*trigger a drone to perform ending part of delivery*/
    add_desire(drone_delivery(B)),
    act (getDrone, Drone),
    add_agent_desire(Drone, finish_delivery(B)),

    
    act dropDown(StartPlatform),
    add_belief(needRecharge)
].

/*  Need to recharge after pkg_switch_reverse*/
add pkg_switch_reverse(_) && (belief needRecharge) => [

    /*get recharging station*/
    act (getChargingStation, CS),

    /*go to the charging station to rest*/
    cr goTo(CS),

    /*wipe out state beliefs*/
    del_belief(busy),
    del_belief(needRecharge),

    /*time to delete the desire pkg_switch_reverse because delivery has been completed*/
    stop
].
