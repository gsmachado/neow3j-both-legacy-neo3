# neow3j-both-legacy-neo3

This is a boilerplate project setup to show that different versions of neow3j can co-exist
in the same project.

It's particularly useful for using neow3j targeting Neo Legacy and Neo N3 networks in
the same application.

## Quickstart

The example can be found in the dir `./src/main/java/com/axlabs/boilerplate/`.

The class `SubscribeToBlocks` basically monitors for new blocks on the Neo Legacy and also in the
Neo N3 chains. For each block, it displays the information.

To run the example, simply execute:

```
./gradlew clean run
```

You will see lots of information being displayed for each new block.