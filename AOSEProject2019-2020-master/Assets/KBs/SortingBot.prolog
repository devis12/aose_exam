:- consult("UnityLogic/KBs/UnityLogicAgentAPI.prolog").

add sort(B) && (\+ belief busy) =>[
    add_belief(busy),

    cr goTo(B),
    act pickUp(B),

    /*Check destination of the box*/
    check_artifact_belief(B, destination(D)),
    check_agent_belief(D, area(Dest)),

    /*Carry B to appropriate exchange area*/
    act (getExchangeArea(Dest), E),
    cr goTo(E),
    act dropDown(E),

    /*trigger destination railbot*/
    act (getRailBot(Dest), RailBot),
    add_agent_desire(RailBot, pkg_switch_reverse(B)),

    /*Need recharge*/
    add_belief(needRecharge)
].

add sort(_) && (belief needRecharge) => [

    /*get recharging station*/
    act (getChargingStation, CS),

    /*go to the charging station to rest*/
    cr goTo(CS),

    del_belief(busy),
    del_belief(needRecharge),

    /*time to delete the desire sort because delivery has been completed*/
    stop

].