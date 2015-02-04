#!/bin/bash
#run file for Permutation test
# put graph.jar in same directory as PermutationTimingApplet.java

echo "java -cp '.:graph.jar' PermutationTimingApplet"
java -cp '.:graph.jar' PermutationTimingApplet


# -cp command sets the java class path, java uses to search for classes. In this case, it is set to search the current directory, and then search inside the graph.jar file.