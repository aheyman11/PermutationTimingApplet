#!/bin/bash
# build file for PermutationTest
# put graph.jar in same directory as PermutationTimingApplet.java

echo "javac -cp '.:graph.jar' PermutationTimingApplet.java"
javac -cp '.:graph.jar' PermutationTimingApplet.java


# -cp command sets the java class path, java uses to search for classes. In this case, it is set to search the current directory, and then search inside the graph.jar file. 