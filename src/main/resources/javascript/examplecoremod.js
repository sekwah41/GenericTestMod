
function otherStuffYouCanRun() {
    print("More stuff from the test script")
}

function initializeCoreMod() {
    print("Running coremod method script!");

    otherStuffYouCanRun();

    /**
     * You can use the mixin or at reference for help e.g. net.minecraft.client.gui.screen.MainMenuScreen init()V #init
     * Descriptors for the types of target
     * https://github.com/MinecraftForge/CoreMods/blob/e6fed88bfcb29bc062c04310f18ebe2777582d03/src/main/java/net/minecraftforge/coremod/CoreMod.java#L66
     * see net.minecraftforge.coremod.CoreMod.buildCore
     *
     * At time of writing target parameters for each 'type'
     *
     * METHOD
     *     class - string of class name
     *     methodName - string of method name
     *     methodDesc - string of method description
     * CLASS
     *     name - string of class name
     *       or
     *     names - function that takes a list of classes and returns an array of targets
     * FIELD
     *     class - string of class name
     *     fieldName - string of field name
     *
     * transformer - look at org.objectweb.asm for more info
     * METHOD - org.objectweb.asm.tree.MethodNode
     */
    return {
        'generictestmethod': {
            'target': {
                'type': 'METHOD',
                'class': 'net.minecraft.client.gui.screen.MainMenuScreen',
                'methodName': 'init',
                'methodDesc': '()V'
            },
            'transformer': function(method) {

                var ASMAPI = Java.type('net.minecraftforge.coremod.api.ASMAPI');

                var Opcodes = Java.type('org.objectweb.asm.Opcodes');

                var basicHook = ASMAPI.loadFile("basichook.js");

                var methodList = ASMAPI.listOf(
                    ASMAPI.buildMethodCall("com/sekwah/generictestmod/coremod/CoreModTestCalls", "testCall", "()V",
                        ASMAPI.MethodType.STATIC));

                /*if(ASMAPI.insertInsnList(method, ASMAPI.MethodType.STATIC, "")) {
                    throw "MethodInsnNode for init not found";
                }*/

                print("Transformed init()V");

                return method;
            }
        }
    }
}