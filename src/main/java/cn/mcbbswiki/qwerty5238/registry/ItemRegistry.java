package cn.mcbbswiki.qwerty5238.registry;

import cn.mcbbswiki.qwerty5238.item.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * @author QWERTY_52_38@mcbbs-wiki.cn
 */
public abstract class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "mcbbswiki");

    public static RegistryObject<Item> block_qwerty5238 = ITEMS.register("block_qwerty5238", () -> new BlockItem(BlockRegistry.block_qwerty5238.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    // qwerty

    public static RegistryObject<Item> block_eicy = ITEMS.register("block_eicy", () -> new BlockItem(BlockRegistry.block_eicy.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static RegistryObject<Item> block_sheeprealms = ITEMS.register("block_sheeprealms", () -> new BlockItem(BlockRegistry.block_sheeprealms.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static RegistryObject<Item> block_mashkjo = ITEMS.register("block_mashkjo", () -> new BlockItem(BlockRegistry.block_mashkjo.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static RegistryObject<Item> block_freeliealgebra = ITEMS.register("block_freeliealgebra", () -> new BlockItem(BlockRegistry.block_freeliealgebra.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static RegistryObject<Item> block_saltlovely = ITEMS.register("block_saltlovely", () -> new BlockItem(BlockRegistry.block_saltlovely.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static RegistryObject<Item> block_woshiren1012 = ITEMS.register("block_woshiren1012", () -> new BlockItem(BlockRegistry.block_woshiren1012.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static RegistryObject<Item> block_whitei = ITEMS.register("block_whitei", () -> new BlockItem(BlockRegistry.block_whitei.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    // administrators

    public static RegistryObject<Item> block_noobx = ITEMS.register("block_noobx", () -> new BlockItem(BlockRegistry.block_noobx.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static RegistryObject<Item> block_aurora = ITEMS.register("block_aurora", () -> new BlockItem(BlockRegistry.block_aurora.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static RegistryObject<Item> block_eminfantry = ITEMS.register("block_eminfantry", () -> new BlockItem(BlockRegistry.block_eminfantry.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    // 2020/11/25 to 2020/11/26 -- added at 2020/11/26 19:27

    public static RegistryObject<Item> item_sword_eee = ITEMS.register("item_sword_eee", ItemSwordEEE::new);
    public static RegistryObject<Item> item_eee = ITEMS.register("item_eee", ItemEEE::new);
    public static RegistryObject<Item> item_stacked_eee = ITEMS.register("item_stacked_eee", ItemStackedEEE::new);
    // eee

    public static RegistryObject<Item> block_mcbbswiki_base_ore = ITEMS.register("block_mcbbswiki_base_ore", () -> new BlockItem(BlockRegistry.block_mcbbswiki_base_ore.get(), new Item.Properties().group(ModGroupRegistry.McbbsWikiGroup)));
    public static RegistryObject<Item> item_mcbbswiki_ingot = ITEMS.register("item_mcbbswiki_ingot", ItemMcbbsWikiIngot::new);
    public static RegistryObject<Item> item_mcbbswiki_helmet_level1 = ITEMS.register("item_mcbbswiki_helmet_level1", ItemMcbbsWikiHelmetLevel1::new);
    public static RegistryObject<Item> item_mcbbswiki_chestplate_level1 = ITEMS.register("item_mcbbswiki_chestplate_level1", ItemMcbbsWikiChestplateLevel1::new);
    public static RegistryObject<Item> item_mcbbswiki_leggings_level1 = ITEMS.register("item_mcbbswiki_leggings_level1", ItemMcbbsWikiLeggingsLevel1::new);
    public static RegistryObject<Item> item_mcbbswiki_boots_level1 = ITEMS.register("item_mcbbswiki_boots_level1", ItemMcbbsWikiBootsLevel1::new);
    // mcbbs wiki things
}
