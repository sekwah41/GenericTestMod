/*
If you reuse this file in any projects please leave this message in
Generic Test Mod https://github.com/sekwah41/GenericTestMod

You dont need to make your project open source to use any of these though if you make any new methods it would be
appreciated if you could make a pr if they seem like generally helpful methods. As long as we see it as helpful even
if there isn't an example of its usecase we will include it.

Changes
 - Put any changes you made here
 */

/*
 * Dev notes
 *
 * Currently testing methods. Will clean it up to be easier to use once I have done the experimentation I need to.
 *
 * The main objective of this file is to try to make the asm more human readable and shorter rather than easier to do.
 * If you don't know what you are doing you should expect horrible errors though that should not defer you from trying.
 * Just make sure you ask yourself, is it possible without asm? This should be done as a last resort for most things.
 *
 * Anything stored in the global scope will be loaded into other files so if you want to keep it clean i would recommend
 * running any large code planning to be reused in functions that output a usable json object for the library.
 *
 * Probably best to abbreviate anything you dont want to be interact with other code with something. We will use gtm_
 * for generic test mod to avoid clashes.
 *
 * When writing js in these files remember it is heavily outdated. You cant run any fancy new JS. I believe it is ES5
 * with a little of ES6 implemented though I may be wrong.
 */

/**
 * Setup library object to allow easier more clear calling
 * TODO map out functions once it has been decided what the basics of this file will do.
 * @return any
 */
function setupJSASMHelper (){
    var ASMAPI = Java.type('net.minecraftforge.coremod.api.ASMAPI');

    function hookAtHead(method) {


        // TODO get first and inject before that
    }

// Designed to function similar to the mixin "HEAD"
    function hookAtReturn(method) {

        var Opcodes = Java.type('org.objectweb.asm.Opcodes');

        // TODO Get opcode of return and inject at all before that.

        /*var arrayLength = method.instructions.size();
        for (var i = 0; i < arrayLength; ++i) {
            var instruction = method.instructions.get(i);
            print(instruction);
            print(instruction.getOpcode());
            /!*if (instruction.getOpcode() == Opcodes.ICONST_1) {
                var InsnNode = Java.type('org.objectweb.asm.tree.InsnNode');
                var newInstruction = new InsnNode(Opcodes.ICONST_0);
                method.instructions.insertBefore(instruction, newInstruction);
                method.instructions.remove(instruction);
                print("Transformed!");
                break;
            }*!/
        }*/
    }

    return {
        hookAtHead: hookAtHead,
        hookAtReturn: hookAtReturn
    };
}

var jsASMHelper = setupJSASMHelper();
