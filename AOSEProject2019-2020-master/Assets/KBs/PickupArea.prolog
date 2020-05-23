:- consult("UnityLogic/KBs/UnityLogicAgentAPI.prolog").

/*  Pickup area triggered by the GameManager
    to call a drone in order to deliver box B

    B has belief start(S) & destination(D)
*/
add call_drone(B) && true => [
    /*extract area info*/
    check_belief(area(MyArea)),
    
    /*check for the source area of B*/
    check_artifact_belief(B, start(S)),
    check_agent_belief(S, area(StartArea)),
    
    /*check that the right pickup area has been triggered*/
    MyArea = StartArea,

    /*trigger a drone to perform init actual delivery*/
    act (getDrone, Drone),
    (
        not(check_agent_belief(Drone, busy)),
        add_agent_belief(Drone, busy)
    ),
    add_agent_desire(Drone, init_delivery(B)),

    stop
].

/*  Pickup area triggered by a drone delivering the box B

    B has belief start(S) & destination(D)
*/
add delivered(B) && true => [
    /*extract area info*/
    check_belief(area(MyArea)),
    
    /*check for the destination area of B*/
    check_artifact_belief(B, destination(D)),
    check_agent_belief(D, area(DestinationArea)),
    
    /*check that the right pickup area has been triggered*/
    MyArea = DestinationArea,

    /*trigger a drone to perform init actual delivery*/
    act destroy(B),

    stop
].