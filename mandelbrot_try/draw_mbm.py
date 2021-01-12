# Base:
# to get a "picture" of the Mandelbrot set we have to plot every point which doesnt go against
# infinity for for lime n->inf zn+1 = zn^2+c , c = x+iy
# if at any point the equation happens to yield a value greater 2 it is safe to say that it is not in the set

import matplotlib.pyplot as plt


# tup tup -> tup
# multiplies two complex numbers
def multiply_c_number(n1, n2):
    return n1[0] * n2[0] - n1[1] * n2[1], n1[0] * n2[1] + n1[1] * n2[0]


# tup tup -> tup
# adds two complex numbers
def add_c_number(n1, n2):
    return n1[0] + n2[0], n1[1] + n2[1]


# tup tup -> tup
# represents the given equation
mb_equation = lambda zn, c: add_c_number(multiply_c_number(zn, zn), c)


# function int list list -> list
# propagates given equation for n steps
def propagate_equation(equation, num_iter, z0, c):
    point = z0
    for i in range(num_iter):
        point = equation(point, c)
    return point


def in_set(c, z0, num_iter, exit_num):
    value = z0

    for i in range(num_iter):
        if value[0]**2+value[1]**2 >= 8:
            return False
        else:
            value = propagate_equation(mb_equation, 1, value, c)
    return True



def draw_the_set(x_size, y_size,  acc):
    import matplotlib.pyplot as plt
    x_cord = []
    y_cord = []
    min_x = int(x_size[0] / acc)
    max_x = int(x_size[1]/acc)
    min_y = int(y_size[0] / acc)
    max_y = int(y_size[1]/acc)
    for x in range(min_x, max_x):
        for y in range(min_y, max_y):

            if in_set((x*acc, y*acc), (0, 0), 100, 2):
                x_cord.append(x*acc)
                y_cord.append(y*acc)

    plt.scatter(x_cord, y_cord, color="black", s=0.1)

    # x-axis label
    plt.xlabel('Re(Z)')
    # frequency label
    plt.ylabel('Im(Z)')
    # plot title
    plt.title('Mandelbrot')

    # function to show the plot
    plt.show()


draw_the_set((-2, 2), (-2, 2), 0.005)
