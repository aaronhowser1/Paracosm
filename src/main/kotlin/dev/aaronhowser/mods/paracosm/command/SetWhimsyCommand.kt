package dev.aaronhowser.mods.paracosm.command

import com.mojang.brigadier.arguments.FloatArgumentType
import com.mojang.brigadier.builder.ArgumentBuilder
import com.mojang.brigadier.context.CommandContext
import dev.aaronhowser.mods.paracosm.attachment.Whimsy.Companion.whimsy
import net.minecraft.commands.CommandSourceStack
import net.minecraft.commands.Commands
import net.minecraft.commands.arguments.EntityArgument
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.player.Player

object SetWhimsyCommand {

    private const val AMOUNT_ARGUMENT = "amount"
    private const val TARGET_ARGUMENT = "target"

    fun register(): ArgumentBuilder<CommandSourceStack, *> {
        return Commands
            .literal("setWhimsy")
            .requires { it.hasPermission(2) }
            .then(
                Commands
                    .argument(AMOUNT_ARGUMENT, FloatArgumentType.floatArg(0f))
                    .executes { setWhimsy(it, null) }
                    .then(
                        Commands
                            .argument(TARGET_ARGUMENT, EntityArgument.player())
                            .executes { setWhimsy(it, EntityArgument.getEntity(it, TARGET_ARGUMENT)) }
                    )
            )
    }

    private fun setWhimsy(
        context: CommandContext<CommandSourceStack>,
        entity: Entity?
    ): Int {
        val commandSender = context.source.entity as? Player ?: return 0
        val target = (entity ?: context.source.entity) as? Player ?: return 0

        val amount = FloatArgumentType.getFloat(context, AMOUNT_ARGUMENT)

        target.whimsy = amount

        commandSender.sendSystemMessage(Component.literal("Set ${target.gameProfile.name}'s Whimsy to $amount"))
        if (target != commandSender) target.sendSystemMessage(Component.literal("${commandSender.gameProfile.name} set your Whimsy to $amount"))

        return 1
    }

}