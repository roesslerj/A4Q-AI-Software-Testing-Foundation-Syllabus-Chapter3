mkdir -p target
javac -cp "lib/*" src/main/java/RemoveElementTransformer.java -d target
javac -cp "lib/*:target" src/main/java/BuggyRemoveElementTransformer.java -d target
javac -cp "lib/*:target" src/test/java/RemoveElementTransformerTest.java -d target
