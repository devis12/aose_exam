;; domain file: puzzle-domain.pddl
(define (domain puzzle-domain)
    (:requirements :strips :negative-preconditions)
    
    (:predicates 
        (greater ?x ?y)

        (free ?r ?c)
        (isOn ?tile ?r ?c)
    )
    
    (:action moveUp
        :parameters (?x ?r1 ?c ?r2)
        :precondition (and (greater ?r1 ?r2) (isOn ?x ?r1 ?c) (free ?r2 ?c))
        :effect (and (not(isOn ?x ?r1 ?c)) (not(free ?r2 ?c)) (isOn ?x ?r2 ?c) (free ?r1 ?c))
    )

    (:action moveDown
        :parameters (?x ?r1 ?c ?r2)
        :precondition (and (greater ?r2 ?r1) (isOn ?x ?r1 ?c) (free ?r2 ?c))
        :effect (and (not(isOn ?x ?r1 ?c)) (not(free ?r2 ?c)) (isOn ?x ?r2 ?c) (free ?r1 ?c))
    )

    (:action moveLeft
        :parameters (?x ?r ?c1 ?c2)
        :precondition (and (greater ?c1 ?c2) (isOn ?x ?r ?c1) (free ?r ?c2))
        :effect (and (not(isOn ?x ?r ?c1)) (not(free ?r ?c2)) (isOn ?x ?r ?c2) (free ?r ?c1))
    )

    (:action moveRight
        :parameters (?x ?r ?c1 ?c2)
        :precondition (and (greater ?c2 ?c1) (isOn ?x ?r ?c1) (free ?r ?c2))
        :effect (and (not(isOn ?x ?r ?c1)) (not(free ?r ?c2)) (isOn ?x ?r ?c2) (free ?r ?c1))
    )

)