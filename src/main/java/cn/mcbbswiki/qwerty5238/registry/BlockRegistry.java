package cn.mcbbswiki.qwerty5238.registry;

import cn.mcbbswiki.qwerty5238.block.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * @author QWERTY_52_38@mcbbs-wiki.cn
 */
public abstract class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "mcbbswiki");

    public static RegistryObject<Block> block_qwerty5238 = BLOCKS.register("block_qwerty5238", BlockQwerty5238::new);
    // qwerty

    public static RegistryObject<Block> block_eicy = BLOCKS.register("block_eicy", BlockEicy::new);
    public static RegistryObject<Block> block_sheeprealms = BLOCKS.register("block_sheeprealms", BlockSheepRealms::new);
    public static RegistryObject<Block> block_mashkjo = BLOCKS.register("block_mashkjo", BlockMashkjo::new);
    public static RegistryObject<Block> block_freeliealgebra = BLOCKS.register("block_freeliealgebra", BlockFreeLieAlgebra::new);
    public static RegistryObject<Block> block_saltlovely = BLOCKS.register("block_saltlovely", BlockSaltLovely::new);
    public static RegistryObject<Block> block_woshiren1012 = BLOCKS.register("block_woshiren1012", BlockWoShiRen1012::new);
    public static RegistryObject<Block> block_whitei = BLOCKS.register("block_whitei", BlockWhitei::new);
    // administrators

    public static RegistryObject<Block> block_noobx = BLOCKS.register("block_noobx", BlockNoobX::new);
    public static RegistryObject<Block> block_aurora = BLOCKS.register("block_aurora", BlockAurora::new);
    public static RegistryObject<Block> block_eminfantry = BLOCKS.register("block_eminfantry", BlockEMInfantry::new);
    // 2020/11/25 to 2020/11/26 -- added at 2020/11/26 19:27

    public static RegistryObject<Block> block_mcbbswiki_base_ore = BLOCKS.register("block_mcbbswiki_base_ore", BlockMcbbsWikiBaseOre::new);
    public static RegistryObject<Block> block_mcbbswiki = BLOCKS.register("block_mcbbswiki", BlockMcbbsWiki::new);
    public static RegistryObject<Block> block_mcbbswiki_lucky_block = BLOCKS.register("block_mcbbswiki_lucky_block", BlockMcbbsWikiLuckyBlock::new);
    public static RegistryObject<Block> block_mysterious = BLOCKS.register("block_mysterious", BlockMysterious::new);
    // others
}
