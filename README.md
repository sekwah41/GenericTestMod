GenericTestMod
======
This project is designed to show off random things you can do in modded Minecraft.

This contains the basic forge example mod provided with the mdk.

## Got a suggestion?
Feel free to open an issue, pull request or ping me on discord. I am always open to learn more or improve my code style
and depending on how much time I have will be making possibly some tutorials based off the code here, so I would like to
keep it up to date with best practices to use as a good example.

## Got an issue?
Not my problem. These examples are here for you to learn from or have fun with.
While you can get help from large portions of the community quite easily if you ask a stupid question you are going to get a stupid answer.
Try to solve it yourself else you will never learn.

If you don't know Java you are going to struggle, learning this way is not an ideal way to learn from scratch.
Though playing with other peoples projects or altering existing code may help you, don't expect to instantly be able to make a lot of new content.

### Examples
Ore Generation  
Feature Generation  
Custom Features  
AccessTransformers  
JSCoreMod - [Good reference for example scripts](https://github.com/MinecraftForge/CoreMods/tree/e6fed88bfcb29bc062c04310f18ebe2777582d03/src/test/javascript)

### Not fully supported examples
**Forge Mixins** - Waiting for official implementation, for now only works in dev, for now if you build mods mixins will just
be ignored by a client though at least you can still play with it for now.

## Mixins Notice
Lex is currently actively choosing not to ship Mixin's with forge in its current state (as Mumfrey does not feel its in a good enough state).
This looks like it will change once Mumfrey deems them.
stable enough to work in forge.

## Services in dev
**I need to find a proper way to build MANIFEST to the src though for now copy from after a build to test**  
/build/tmp/jar/

The META-INF will be ignored in the resources though it is needed to properly link mixins for now without anything else.

## Useful Tools/Info
Hotswapping that I didn't know existed for far too long
https://dcevm.github.io/.
Check https://aur.archlinux.org/packages/jdk8-openjdk-dcevm for an easy install on arch.

## Will you do fabric examples?
For now no, though there is a lot of help on the fabric discord https://discord.gg/v6v4pMv

While it is fun to mod the new forge code wise is actually really nice.

We are going to take a look at mapping the MCP names over to fabric for easier porting of mods as Fabric has a much
better decompiling system which can support a lot more changes.
