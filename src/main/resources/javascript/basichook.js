// Designed to function similar to the mixin "RETURN"
function hookAtHead(method) {


    // TODO get first and inject before that
}

// Designed to function similar to the mixin "HEAD"
function hookAtReturn(method) {

    var ASMAPI = Java.type('net.minecraftforge.coremod.api.ASMAPI');

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