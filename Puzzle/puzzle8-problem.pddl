;; problem file: puzzle8-problem.pddl
(define (problem puzzle8-problem)
    (:domain puzzle-domain)
    (:objects 
        ;;tiles definition
        t1 t2 t3
        t4 t5 t6
        t7 t8

        ;;rows definition
        r1 r2 r3 

        ;;column definition
        c1 c2 c3
    )
    (:init 
        ;;rows position
        (greater r2 r1)
        (greater r3 r2)
        
        ;;column position
        (greater c2 c1)
        (greater c3 c2)
        
        ;; tiles position
        ;; 2 6 1
        ;;   7 8
        ;; 3 5 4
        (isOn t2 r1 c1)
        (isOn t6 r1 c2)
        (isOn t1 r1 c3)

        (free    r2 c1)
        (isOn t7 r2 c2)
        (isOn t8 r2 c3)

        (isOn t3 r3 c1)
        (isOn t5 r3 c2)
        (isOn t4 r3 c3)
    )
    (:goal (and 
        (isOn t1 r1 c1)
        (isOn t2 r1 c2)
        (isOn t3 r1 c3)

        (isOn t4 r2 c1)
        (isOn t5 r2 c2)
        (isOn t6 r2 c3)

        (isOn t7 r3 c1)
        (isOn t8 r3 c2)
        (free    r3 c3)
    ))
)