
function otherFunctionToRun() {
    print("More stuff from the test script")
}

function initializeCoreMod() {
    print("Running coremod method script!");

    var ASMAPI = Java.type('net.minecraftforge.coremod.api.ASMAPI');

    ASMAPI.log("INFO", "Testing log function");

    // Locations are relative to the resources folder. Not the current file.
    ASMAPI.loadFile('javascript/jsasmhelper.js');

    jsASMHelper.log.info("Here is an info message");
    jsASMHelper.log.warn("Here is a warning message");
    jsASMHelper.log.error("Here is an error message");
    jsASMHelper.log.debug("Here is a debug message");
    jsASMHelper.log.fatal("Here is a fatal message");

    otherFunctionToRun();

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
        'mainmenuinit': {
            'target': {
                'type': 'METHOD',
                'class': 'net.minecraft.client.gui.screen.MainMenuScreen',
                'methodName': 'init',
                'methodDesc': '()V'
            },
            'transformer': function(method) {
                jsASMHelper.log.info("Transformed init()V");
                jsASMHelper.log.info(method);

                jsASMHelper.class("com/sekwah/generictestmod/coremod/CoreModTestCalls")
                    .method("testCall")
                    .voidDesc().print();

                // jsASMHelper.createMethodCall()
                //     .class("com/sekwah/generictestmod/coremod/CoreModTestCalls")
                //     .method("testCall").void();

                return method;
            }
        }
    }
}
