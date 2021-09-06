package cn.mcbbswiki.qwerty5238.registry;

import cn.mcbbswiki.qwerty5238.item.*;
import cn.mcbbswiki.qwerty5238.item.level1.*;
import cn.mcbbswiki.qwerty5238.item.level2.*;
import cn.mcbbswiki.qwerty5238.item.technical.CustomSpawnEggItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * @author QWERTY_52_38@mcbbs-wiki.cn
 */
public abstract class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "mcbbswiki");
    public static final RegistryObject<Item> block_qwerty5238 = ITEMS.register("block_qwerty5238", () -> new BlockItem(BlockRegistry.block_qwerty5238.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    // qwerty

    public static final RegistryObject<Item> block_eicy = ITEMS.register("block_eicy", () -> new BlockItem(BlockRegistry.block_eicy.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static final RegistryObject<Item> block_sheeprealms = ITEMS.register("block_sheeprealms", () -> new BlockItem(BlockRegistry.block_sheeprealms.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static final RegistryObject<Item> block_mashkjo = ITEMS.register("block_mashkjo", () -> new BlockItem(BlockRegistry.block_mashkjo.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static final RegistryObject<Item> block_freeliealgebra = ITEMS.register("block_freeliealgebra", () -> new BlockItem(BlockRegistry.block_freeliealgebra.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static final RegistryObject<Item> block_saltlovely = ITEMS.register("block_saltlovely", () -> new BlockItem(BlockRegistry.block_saltlovely.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static final RegistryObject<Item> block_woshiren1012 = ITEMS.register("block_woshiren1012", () -> new BlockItem(BlockRegistry.block_woshiren1012.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static final RegistryObject<Item> block_whitei = ITEMS.register("block_whitei", () -> new BlockItem(BlockRegistry.block_whitei.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    // administrators

    public static final RegistryObject<Item> block_noobx = ITEMS.register("block_noobx", () -> new BlockItem(BlockRegistry.block_noobx.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static final RegistryObject<Item> block_aurora = ITEMS.register("block_aurora", () -> new BlockItem(BlockRegistry.block_aurora.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static final RegistryObject<Item> block_eminfantry = ITEMS.register("block_eminfantry", () -> new BlockItem(BlockRegistry.block_eminfantry.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    // 2020/11/25 to 2020/11/26 -- added at 2020/11/26 19:27

    public static final RegistryObject<Item> item_sword_eee = ITEMS.register("item_sword_eee", ItemSwordEEE::new);
    public static final RegistryObject<Item> item_eee = ITEMS.register("item_eee", ItemEEE::new);
    public static final RegistryObject<Item> item_stacked_eee = ITEMS.register("item_stacked_eee", ItemStackedEEE::new);
    // eee

    public static final RegistryObject<Item> block_mcbbswiki_base_ore = ITEMS.register("block_mcbbswiki_base_ore", () -> new BlockItem(BlockRegistry.block_mcbbswiki_base_ore.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static final RegistryObject<Item> item_mcbbswiki_ingot = ITEMS.register("item_mcbbswiki_ingot", ItemMcbbsWikiIngot::new);
    public static final RegistryObject<Item> item_transporter = ITEMS.register("item_transporter", ItemTransporter::new);
    public static final RegistryObject<Item> block_mcbbswiki = ITEMS.register("block_mcbbswiki", () -> new BlockItem(BlockRegistry.block_mcbbswiki.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static final RegistryObject<Item> item_mcbbswiki_lucky_block_piece = ITEMS.register("item_mcbbswiki_lucky_block_piece", ItemMcbbsWikiLuckyBlockPiece::new);
    public static final RegistryObject<Item> block_mcbbswiki_lucky_block = ITEMS.register("block_mcbbswiki_lucky_block", () -> new BlockItem(BlockRegistry.block_mcbbswiki_lucky_block.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    // something important

    public static final RegistryObject<Item> item_mcbbswiki_helmet_level1 = ITEMS.register("item_mcbbswiki_helmet_level1", ItemMcbbsWikiHelmetLevel1::new);
    public static final RegistryObject<Item> item_mcbbswiki_chestplate_level1 = ITEMS.register("item_mcbbswiki_chestplate_level1", ItemMcbbsWikiChestplateLevel1::new);
    public static final RegistryObject<Item> item_mcbbswiki_leggings_level1 = ITEMS.register("item_mcbbswiki_leggings_level1", ItemMcbbsWikiLeggingsLevel1::new);
    public static final RegistryObject<Item> item_mcbbswiki_boots_level1 = ITEMS.register("item_mcbbswiki_boots_level1", ItemMcbbsWikiBootsLevel1::new);

    public static final RegistryObject<Item> item_mcbbswiki_pickaxe_level1 = ITEMS.register("item_mcbbswiki_pickaxe_level1", ItemMcbbsWikiPickaxeLevel1::new);
    public static final RegistryObject<Item> item_mcbbswiki_axe_level1 = ITEMS.register("item_mcbbswiki_axe_level1", ItemMcbbsWikiAxeLevel1::new);
    public static final RegistryObject<Item> item_mcbbswiki_shovel_level1 = ITEMS.register("item_mcbbswiki_shovel_level1", ItemMcbbsWikiShovelLevel1::new);
    public static final RegistryObject<Item> item_mcbbswiki_hoe_level1 = ITEMS.register("item_mcbbswiki_hoe_level1", ItemMcbbsWikiHoeLevel1::new);
    public static final RegistryObject<Item> item_mcbbswiki_sword_level1 = ITEMS.register("item_mcbbswiki_sword_level1", ItemMcbbsWikiSwordLevel1::new);
    // mcbbs wiki things level 1

    public static final RegistryObject<Item> item_mcbbswiki_helmet_level2 = ITEMS.register("item_mcbbswiki_helmet_level2", ItemMcbbsWikiHelmetLevel2::new);
    public static final RegistryObject<Item> item_mcbbswiki_chestplate_level2 = ITEMS.register("item_mcbbswiki_chestplate_level2", ItemMcbbsWikiChestplateLevel2::new);
    public static final RegistryObject<Item> item_mcbbswiki_leggings_level2 = ITEMS.register("item_mcbbswiki_leggings_level2", ItemMcbbsWikiLeggingsLevel2::new);
    public static final RegistryObject<Item> item_mcbbswiki_boots_level2 = ITEMS.register("item_mcbbswiki_boots_level2", ItemMcbbsWikiBootsLevel2::new);

    public static final RegistryObject<Item> item_mcbbswiki_pickaxe_level2 = ITEMS.register("item_mcbbswiki_pickaxe_level2", ItemMcbbsWikiPickaxeLevel2::new);
    public static final RegistryObject<Item> item_mcbbswiki_axe_level2 = ITEMS.register("item_mcbbswiki_axe_level2", ItemMcbbsWikiAxeLevel2::new);
    public static final RegistryObject<Item> item_mcbbswiki_shovel_level2 = ITEMS.register("item_mcbbswiki_shovel_level2", ItemMcbbsWikiShovelLevel2::new);
    public static final RegistryObject<Item> item_mcbbswiki_hoe_level2 = ITEMS.register("item_mcbbswiki_hoe_level2", ItemMcbbsWikiHoeLevel2::new);
    public static final RegistryObject<Item> item_mcbbswiki_sword_level2 = ITEMS.register("item_mcbbswiki_sword_level2", ItemMcbbsWikiSwordLevel2::new);
    // mcbbs wiki things level 2

    public static final RegistryObject<Item> item_mysterious_switch = ITEMS.register("item_mysterious_switch", ItemMysteriousSwitch::new);
    public static final RegistryObject<Item> item_mysterious_ingot = ITEMS.register("item_mysterious_ingot", ItemMysteriousIngot::new);
    public static final RegistryObject<Item> item_mysterious_ingot_piece = ITEMS.register("item_mysterious_ingot_piece", ItemMysteriousIngotPiece::new);
    public static final RegistryObject<Item> block_mysterious = ITEMS.register("block_mysterious", () -> new BlockItem(BlockRegistry.block_mysterious.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    // mysterious

    public static final RegistryObject<CustomSpawnEggItem> item_small_mcbbswiki_monster_spawn_egg = registerSpawnEgg("item_small_mcbbswiki_monster", EntityRegistry.entity_small_mcbbswiki_monster, 0x7bd4ff, 0xff8784);
    public static final RegistryObject<CustomSpawnEggItem> item_middle_mcbbswiki_monster_spawn_egg = registerSpawnEgg("item_middle_mcbbswiki_monster", EntityRegistry.entity_middle_mcbbswiki_monster, 0x6bc4ef, 0xef7774);
    public static final RegistryObject<CustomSpawnEggItem> item_large_mcbbswiki_monster_spawn_egg = registerSpawnEgg("item_large_mcbbswiki_monster", EntityRegistry.entity_large_mcbbswiki_monster, 0x5bb4df, 0xdf6764);
    public static final RegistryObject<CustomSpawnEggItem> item_ray_of_sunshine_spawn_egg = registerSpawnEgg("item_ray_of_sunshine", EntityRegistry.entity_ray_of_sunshine, 0x66ccff, 0xff3300);

    /**
     * register spawn eggs
     * code source:https://github.com/HungTeen/pvzmod/blob/master/src/main/java/com/hungteen/pvz/register/ItemRegister.java
     */
    private static RegistryObject<CustomSpawnEggItem> registerSpawnEgg(String name, RegistryObject<? extends EntityType<?>> entityType, int color1, int color2){
        return ITEMS.register(name + "_spawn_egg", () -> new CustomSpawnEggItem(entityType, color1, color2, new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    }
}
