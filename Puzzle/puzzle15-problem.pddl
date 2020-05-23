;; problem file: puzzle14-problem.pddl
(define (problem puzzle15-problem)
    (:domain puzzle-domain)
    (:objects 
        ;;tiles definition
        t1  t2  t3  t4
        t5  t6  t7  t8
        t9  t10 t11 t12
        t13 t14 t15

        ;;rows definition
        r1 r2 r3 r4

        ;;column definition
        c1 c2 c3 c4
    )
    (:init 
        ;;rows position
        (greater r2 r1)
        (greater r3 r2)
        (greater r4 r3)
        
        ;;column position
        (greater c2 c1)
        (greater c3 c2)
        (greater c4 c3)
        
        ;; tiles position
        ;; 15 2  1 12
        ;; 8  5  6 11 
        ;; 4  9 10 7
        ;; 3 13 14
        (isOn t15 r1 c1)
        (isOn t2  r1 c2)
        (isOn t1  r1 c3)
        (isOn t12 r1 c4)

        (isOn t8  r2 c1)
        (isOn t5  r2 c2)
        (isOn t6  r2 c3)
        (isOn t11 r2 c4)

        (isOn t4  r3 c1)
        (isOn t9  r3 c2)
        (isOn t10 r3 c3)
        (isOn t7  r3 c4)

        (isOn t3  r4 c1)
        (isOn t13 r4 c2)
        (isOn t14 r4 c3)
        (free     r4 c4)
    )
    (:goal (and 
        (isOn t1  r1 c1)
        (isOn t2  r1 c2)
        (isOn t3  r1 c3)
        (isOn t4  r1 c4)

        (isOn t5  r2 c1)
        (isOn t6  r2 c2)
        (isOn t7  r2 c3)
        (isOn t8  r2 c4)

        (isOn t9  r3 c1)
        (isOn t10 r3 c2)
        (isOn t11 r3 c3)
        (isOn t12 r3 c4)

        (isOn t13 r4 c1)
        (isOn t14 r4 c2)
        (isOn t15 r4 c3)
        (free     r4 c4)
    ))
)