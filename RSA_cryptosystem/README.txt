Quick sketch to show basic principal of RSA encryption.

The security of RSA relies on the practical difficulty of factoring 
the product of two large prime numbers, the "factoring problem".


Steps to generate public and private keys:

1. choose 2 large prime numbers (>512 Bit) p,q
-> generate random number of given length
-> ensure it is not divisble by first x primes
-> x times MillerRabin test to be sure enough it is probably a prime


2. Let m be phi(p*q) = (p-1)*(q-1)

3. choose e such that it is a prime but not a primefactor of m

4. find a number d such that d*m mod m = 1
-> solve gcdExtended for  e and m

5. Set public key (n, e)

6. Set private key (n, d)

7. Encrypt T with V = T^e mod n (given by public key)

8. Decrypt V with T = V^d mod n (only private key can)


