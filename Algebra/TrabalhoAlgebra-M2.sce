for x = 1:10
    P1 = (2*x+4)*1.75
    P2 = P1/1.4
    P3 = P2+10
    P4 = P3/2

    A = [P1,P2,P3,P4;0,1,1,0;-1,0,0,1;1,1,1,1]
    B = [7945;100;140;500]

    //disp("Preços")
    //disp(P4,"P4: ",P3,"P3: ",P2,"P2: ",P1,"P1: ")
    //disp(B,"Matriz B:",A,"Matriz A:")
    Gauss = rref([A B])
    Q = A\B
    C = [0,0,0,0]
    for i = 1:4
        if Q(i,1) > 0 then
            C(i,1) = 1
        end
    end
    if (C(1,1) == 1) & (C(2,1) == 1) & (C(3,1) == 1) & (C(4,1) == 1) then
        disp(Gauss,"Gauss Jordan:")
        disp(Q,"Solucao: ")
        disp(x,"Interacao: ")
    end
end
