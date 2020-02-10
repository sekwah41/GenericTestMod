GenericTestMod
======
This project is designed to show off random things you can do in modded Minecraft.

This contains the basic forge example mod provided with the mdk.

## Got a suggestion?
Feel free to open an issue, pull request or ping me on discord. I am always open to learn more or improve my code style
and depending on how much time I have will be making possibly some tutorials based off the code here, so I would like to
keep it up to date with best practices to use as a good example.

## Got an issue?
Google, GitHub and StackOverflow are your friend. If your problem can be easily found there you may be ignored depending
on where you ask. Try not to waste peoples time just to save yourself some time with your questions. Also if you don't
get a quick response don't go just randomly pinging people or demanding help else you may be banned depending on the discord.

My Discord: https://discord.gg/fAJ3xJg (use #tech-and-code I will make a specific channel if a lot of people are joining)
MDC Discord: https://discord.gg/T5MGNBB (use #forge-dev-help)
MMD Discord: https://discord.mcmoddev.com/ (use #mc-development)
Forge Project Discord: https://discord.gg/UvedJ9m (use #modder-support-115)

If you want me specifically for something ping me on a discord or message on my discord.


### Examples
Ore Generation  
Feature Generation  
Custom Features  
AccessTransformers  

### Not fully supported examples
**Forge Mixins** - Waiting for official implementation, for now only works in dev, for now if you build mods mixins will just
be ignored by a client though at least you can still play with it for now.

### Examples to do
JSCoreMod

## Mixins Notice
May look at making a cleaner workaround than things such as Mixin

If I make anything to do it I will update this readme

## Mappings
This example uses mixed though if you are used to yarn you can change the keyword from mixed to yarn.

More info on mixed/yarn on forge can be found here https://www.tterrag.com/yarn2mcp/

This helps avoid getting unmapped functions though keep in mind some names will change which may be confusing though
its a reasonable tradeoff for having less unnamed functions.

#### Contributing to MCP mappings
**Need to add info as I am not sure how to suggest mappings as of now**

Someone who knows more about mcp feel free to add info here such as the process of updating mapping names if they are
wrong or unmapped. Though this process will be changing soonish if I remember correctly.

#### Contributing to YARN mappings
Info can be found [here](https://github.com/FabricMC/yarn)

Adding to mappings is handled through pull requests.

## Services in dev
**I need to find a proper way to build MANIFEST to the src though for now copy from after a build to test**  
/build/tmp/jar/

The META-INF will be ignored in the resources though it is needed to properly link mixins for now without anything else.

## Will you do fabric examples?
For now no, though there is a lot of help on the fabric discord https://discord.gg/v6v4pMv

While it is fun to mod the new forge code wise is actually really nice,
