.SUFFIXES: .java .class
.java.class:
	javac $*.java

CLASSES = \
        org/mindrot/jbcrypt/BCrypt.java \
        Main.java 

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	java Main

clean:
	$(RM) -rf *.class && rm -f org/mindrot/jbcrypt/BCrypt.class

