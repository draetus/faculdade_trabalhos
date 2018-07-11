clear
close
clc

n = 4
x = [0; 0.25; 0.5; 0.75; 1]
y = [3; 5; 8; 4; 2]

h = x(2,1) - x(1,1)

I = h/2*y(1,1)
for (i=2:(n))
    I = I + h/2*y(i,1)*2
end
I = I + h/2*y(n+1,1)

disp(I, "Resultado:")
