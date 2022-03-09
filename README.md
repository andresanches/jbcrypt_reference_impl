Java reference implementation for one-way hashing of string using the [BCrypt algorithm](https://en.wikipedia.org/wiki/Bcrypt).

Project page: https://www.mindrot.org/projects/jBCrypt/
Maven repository: https://mvnrepository.com/artifact/org.mindrot/jbcrypt

### How to run:

```bash
make && make run
```

Expected output:

```
Plain text: whatsapp:+1234567890
Full hash: $2a$10$/sYCepb03BtaCFGbgAe7ZO0OPpoDdnBxH3easEl2UV20BU7gnigE6
Salt (stored as Admiral Secret): $2a$10$/sYCepb03BtaCFGbgAe7ZO
Hash without salt (to store in cassandra): 0OPpoDdnBxH3easEl2UV20BU7gnigE6

Checking happy path. Expected: true. Actual: true
Checking wrong string. Expected: false. Actual: false
```
