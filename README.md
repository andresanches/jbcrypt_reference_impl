Java reference implementation for one-way hashing of string using the [BCrypt algorithm](https://en.wikipedia.org/wiki/Bcrypt).

Project page: https://www.mindrot.org/projects/jBCrypt/
Maven repository: https://mvnrepository.com/artifact/org.mindrot/jbcrypt

### How to run:

```bash
make && make run
```

Expected output:

```
Plain text: Foo bar baz qux
Salt: $2a$10$/sYCepb03BtaCFGbgAe7ZO
Full hash: $2a$10$/sYCepb03BtaCFGbgAe7ZOx6cZucf82oDn0DB5eLdQOmk/NIBSz4q
Hash without salt: x6cZucf82oDn0DB5eLdQOmk/NIBSz4q

Checking happy path. Expected: true. Actual: true
Checking wrong string. Expected: false. Actual: false
```
