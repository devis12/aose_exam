:- consult("UnityLogic/KBs/UnityLogicAgentAPI.prolog").

/* Triggered by a drone to sort out the delivery of the package,
    which either has to be assigned to a drone 
        (in case the destination area is equal to the start)
    or it has to be put in the exchange area
*/
add init_pkg_switch(B) && (\+ belief busy) => [
    add_belief(busy),

    cr goTo(B),
    act pickUp(B),
    add_belief(holding(B)),

    add_desire(pkg_switch),

    stop
].

/*  Package switch inn the scenario in which the destination is equal to the start area*/
add pkg_switch && ((belief busy), (belief holding(B))) => [
    /*Check start and destination of the box*/
    check_artifact_belief(B, start(S)),
    check_artifact_belief(B, destination(D)),
    check_agent_belief(S, area(Start)),
    check_agent_belief(D, area(Dest)),

    /*Start & Destination area are the same: drop down the package where it was*/
    Start = Dest,

    act (getArea(Dest), DestSame),
    act dropDown(DestSame),
    del_belief(holding(B)),

    /*trigger a drone to perform init actual delivery*/
    act (getDrone, Drone),
    (
        not(check_agent_belief(Drone, busy)),
        add_agent_belief(Drone, busy)
    ),
    add_agent_desire(Drone, finish_delivery(B)),

    add_desire(recharge),

    stop
].

/*  need to recharge */
add recharge && (belief busy) => [
    
    /*get recharging station*/
    act (getChargingStation, CS),

    /*go to the charging station to rest*/
    cr goTo(CS),

    del_belief(busy),
    
    stop
].