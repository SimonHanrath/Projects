import RSA_gen

bits = 1024  # bit-length of used primes (1000 is good)

keys = RSA_gen.gen_key_numbers(1024)

public_key = keys[0]
private_key = keys[1]

# generate a encryptet message (numbers only)
encrypted_message = RSA_gen.encrypt(public_key, 144)

# decrypt encryptet message
decrypted_message = RSA_gen.decrypt(private_key, encrypted_message)

# test if decrypted is 22
print(decrypted_message)



