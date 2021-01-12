import prime_gen

first_primes_list = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                     31, 37, 41, 43, 47, 53, 59, 61, 67,
                     71, 73, 79, 83, 89, 97, 101, 103,
                     107, 109, 113, 127, 131, 137, 139,
                     149, 151, 157, 163, 167, 173, 179,
                     181, 191, 193, 197, 199, 211, 223,
                     227, 229, 233, 239, 241, 251, 257,
                     263, 269, 271, 277, 281, 283, 293,
                     307, 311, 313, 317, 331, 337, 347, 349]


# finds x and y such that s*a+t*b = gcd(a,b)
def gcdExtended(a, b):
    # Base Case
    if a == 0:
        return b, 0, 1

    gcd, x1, y1 = gcdExtended(b % a, a)

    # Update x and y using results of recursive
    # call
    x = y1 - (b // a) * x1
    y = x1

    return gcd, x, y


# find a prime that is not in the given number
def find__prime_not_in(m):
    for prime in first_primes_list:
        if m % prime != 0:
            return prime
    return False


# generates numbers private and public key
def gen_key_numbers(size):
    p = prime_gen.random_prime(size)
    q = prime_gen.random_prime(size)
    n = p * q
    m = (p - 1) * (q - 1)

    e = find__prime_not_in(m)
    if (e == False):
        keys(size)

    d = gcdExtended(m, e)[2] % m

    return (n, e), (n, d)


def encrypt(key, num):
    n = key[0]
    e = key[1]
    return pow(num, e, n)


def decrypt(key, num):
    n = key[0]
    d = key[1]
    return pow(num, d, n)
