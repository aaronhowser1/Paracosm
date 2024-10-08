package dev.aaronhowser.mods.paracosm.datagen

import dev.aaronhowser.mods.paracosm.Paracosm
import dev.aaronhowser.mods.paracosm.registry.ModBlocks
import dev.aaronhowser.mods.paracosm.registry.ModEntityTypes
import dev.aaronhowser.mods.paracosm.registry.ModItems
import net.minecraft.data.PackOutput
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import net.neoforged.neoforge.common.data.LanguageProvider

class ModLanguageProvider(output: PackOutput) : LanguageProvider(output, Paracosm.ID, "en_us") {

    object Item {
        const val TOY_GUN = "item.paracosm.toy_gun"
        const val COOL_GUN = "item.paracosm.cool_gun"
    }

    object Misc {
        const val CREATIVE_TAB = "itemGroup.paracosm"
    }

    object Curios {
        const val SEEING_STONE = "curios.identifier.seeing_stone"
    }

    object Subtitle {
        const val FART = "subtitle.paracosm.fart"
        const val UNFART = "subtitle.paracosm.unfart"
        const val DODGEBALL = "subtitle.paracosm.dodgeball"
        const val SQUEE = "subtitle.paracosm.squee"
        const val STICKY_HAND_THROW = "subtitle.paracosm.sticky_hand_throw"
        const val STICKY_HAND_RETRIEVE = "subtitle.paracosm.sticky_hand_retrieve"
    }

    object Emi {
        const val SEEING_STONE_TAG = "tag.item.curios.seeing_stone"
        const val SWEETS_TAG = "tag.item.paracosm.sweets"
    }

    companion object {
        fun String.toComponent(vararg args: Any): MutableComponent = Component.translatable(this, *args)
    }

    override fun addTranslations() {
        addItem(ModItems.COTTON, "Cotton")
        addItem(ModItems.TOWEL_CAPE, "Towel Cape")
        addItem(ModItems.SEEING_STONE, "Seeing Stone")
        addItem(ModItems.DODGEBALL, "Dodgeball")
        addItem(ModItems.CANDY, "Candy")
        addItem(ModItems.SODA, "Soda")
        addItem(ModItems.WARM_MILK, "Warm Milk")
        addItem(ModItems.SHRINK_RAY, "Shrink Ray")
        add(Item.TOY_GUN, "Toy Gun")
        add(Item.COOL_GUN, "Cool Gun")
        addItem(ModItems.STICKY_HAND, "Sticky Hand")
        addItem(ModItems.POGO_STICK, "Pogo Stick")

        addBlock(ModBlocks.NIGHT_LIGHT, "Night Light")
        addBlock(ModBlocks.WHOOPEE_CUSHION, "Whoopee Cushion")
        addBlock(ModBlocks.COTTON, "Cotton")
        addBlock(ModBlocks.WALRUS, "Walrus")
        addBlock(ModBlocks.IMAGINATOR, "Imaginator")
        addBlock(ModBlocks.CITY_RUG, "City Rug")

        addEntityType(ModEntityTypes.TEDDY_BEAR, "Teddy Bear")
        addEntityType(ModEntityTypes.DODGEBALL, "Dodgeball")
        addEntityType(ModEntityTypes.STRING_WORM, "String Worm")
        addEntityType(ModEntityTypes.AARONBERRY, "Aaronberry")

        add(Misc.CREATIVE_TAB, "Paracosm")

        add(Curios.SEEING_STONE, "Seeing Stone")

        add(Subtitle.FART, "Pbbbbt")
        add(Subtitle.UNFART, "Bbbtpp")
        add(Subtitle.DODGEBALL, "PHONK")
        add(Subtitle.SQUEE, "Squee")
        add(Subtitle.STICKY_HAND_THROW, "Throw Sticky Hand")
        add(Subtitle.STICKY_HAND_RETRIEVE, "Retrieve Sticky Hand")

        add(Emi.SEEING_STONE_TAG, "Seeing Stone")
        add(Emi.SWEETS_TAG, "Sweets")
    }
}