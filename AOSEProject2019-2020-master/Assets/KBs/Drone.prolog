:- consult("UnityLogic/KBs/UnityLogicAgentAPI.prolog").

/*  PickupArea has requested a drone to come take a box B 
    NOTE: busy "lock" set up by pickupArea
*/
add init_delivery(B) && (belief busy) => [
    /*Go to take the object from source house*/
    cr takeOff,
    cr goTo(B),
    cr land,
    act pickUp(B),
    
    add_belief(holding(B))
].

/*  Just pickUp box B and need to take it to the exchange platform
    NOTE: B has belief start(S) & destination(D)
*/
add init_delivery(B) && (belief holding(B)) => [
    /*check for the source & destination area of B*/
    check_artifact_belief(B, start(S)),
    check_artifact_belief(B, destination(D)),
    check_agent_belief(S, area(Start)),
    check_agent_belief(D, area(Dest)),
    
    act printLog("Box needs to be taken from " + Start + " to " + Dest),

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
    act printLog("BEFORE triggering railbot"),
    act (getRailBot(Start), RailBot),
    add_agent_desire(RailBot, pkg_switch(B)),
    act printLog("AFTER triggering railbot"),

    add_belief(needRecharge)
].

/*  need to recharge after init_delivery*/
add init_delivery(_) && (belief needRecharge) => [
    
    /*get recharging station*/
    act (getChargingStation, CS),

    /*go to the charging station to rest*/
    cr takeOff,
    cr goTo(CS),
    cr land,

    del_belief(busy),
    del_belief(needRecharge),
    
    stop
].

/*  trigger by railbot in order to finish the delivery, taking box B to destination address*/
add finish_delivery(B) && (\+ belief busy) => [
    
    add_belief(busy),
    
    /*Pickup box B to deliver it to destination house*/
    cr takeOff,
    cr goTo(B),
    cr land,

    act pickUp(B),
    
    add_belief(holding(B))
].

/*  Just pickUp box B and need to take it to the destination house
    B has belief start(S) & destination(D)
*/
add finish_delivery(B) && (belief holding(B)) => [
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

    add_belief(needRecharge)
].


/*  need to recharge after finish_delivery*/
add finish_delivery(_) && (belief needRecharge) => [
    
    /*get recharging station*/
    act (getChargingStation, CS),

    /*go to the charging station to rest*/
    cr takeOff,
    cr goTo(CS),
    cr land,

    del_belief(busy),
    del_belief(needRecharge),
    
    stop
].