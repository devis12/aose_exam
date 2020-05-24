:- consult("UnityLogic/KBs/UnityLogicAgentAPI.prolog").

/*  PickupArea has requested a drone to come take a box B */
add init_delivery(B) && (belief busy) => [
    
    cr takeOff,
    cr goTo(B),
    cr land,

    act pickUp(B),
    
    add_desire(bring_to_platform),
    add_belief(holding(B)),

    stop
].

/*  Just pickUp box B and need to take it to the exchange platform
        
    B has belief start(S) & destination(D)
*/
add bring_to_platform && ((belief busy), (belief holding(B))) => [
    /*check for the source & destination area of B*/
    check_artifact_belief(B, start(S)),
    check_artifact_belief(B, destination(D)),
    check_agent_belief(S, area(Start)),
    check_agent_belief(D, area(Dest)),
    
    act printLog("I have to take the box from " + Start + " to " + Dest),

    /*get reference for the exchange platform to take the box B to*/
    act (getLandingZone(Start,Dest), L),

    /*go to the landing zone, i.e. exchange platform*/
    cr takeOff,
    cr goTo(L),
    cr land,

    /*dropdown the box*/
    act dropDown,
    del_belief(holding(B)),

    /*trigger railbot of corresp. exchange platform*/
    act (getRailBot(Start), RailBot),
    add_agent_desire(RailBot, init_pkg_switch(B)),

    add_desire(recharge),

    stop
].

/*  trigger by railbot in order to finish the delivery, taking box B to destination address*/
add finish_delivery(B) && true => [
    
    cr takeOff,
    cr goTo(B),
    cr land,

    act pickUp(B),
    
    add_desire(bring_to_house),
    add_belief(holding(B)),

    stop
].

/*  Just pickUp box B and need to take it to the destination house
        
    B has belief start(S) & destination(D)
*/
add bring_to_house && ((belief busy), (belief holding(B))) => [
    /*check for the source & destination area of B*/
    check_artifact_belief(B, destination(D)),

    /*go to the house, i.e. destination platform*/
    cr takeOff,
    cr goTo(D),
    cr land,

    /*dropdown the box*/
    act dropDown,
    del_belief(holding(B)),

    /*trigger pickup area of corresp. destination platform to "consume" package*/
    add_agent_desire(D, delivered(B)),

    add_desire(recharge),

    stop
].

/*  need to recharge */
add recharge && (belief busy) => [
    
    /*get recharging station*/
    act (getChargingStation, CS),

    /*go to the charging station to rest*/
    cr takeOff,
    cr goTo(CS),
    cr land,

    del_belief(busy),
    
    stop
].