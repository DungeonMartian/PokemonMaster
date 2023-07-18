///package pokemonmaster;
///
///import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
///import pokemonmaster.cards.Fighting.*;
///import pokemonmaster.cards.Fire.*;
///import pokemonmaster.cards.Grass.*;
///import pokemonmaster.cards.Lightning.*;
///import pokemonmaster.cards.Metal.*;
///import pokemonmaster.cards.Psychic.*;
///
///import java.util.ArrayList;
///import java.util.Set;
///
///public class PokemonTypeRemover {
///    public static ArrayList<Integer> set = new ArrayList<>();
///
///    public static void removeCards(Set<Integer> set) {
///        //ArrayList<String> Blahtype = new ArrayList<>();
///        //Blahtype.add(.ID);
///        //Blahtype.add(.ID);
///        //Blahtype.add(.ID);
///        //Blahtype.add(.ID);
///        //Blahtype.add(.ID);
///        //Blahtype.add(.ID);
///        //Blahtype.add(.ID);
///        //Blahtype.add(.ID);
///        //Blahtype.add(.ID);
///        //Blahtype.add(.ID);
///        //Blahtype.add(.ID);
///        //Blahtype.add(.ID);
///        //Blahtype.add(.ID);
///        //Blahtype.add(.ID);
///        //Blahtype.add(.ID);
///
///        ArrayList<String> LightningTYPE = new ArrayList<>();
///        LightningTYPE.add(AlolanGeodude.ID);
///        LightningTYPE.add(Blitzle.ID);
///        LightningTYPE.add(Dedenne.ID);
///        LightningTYPE.add(DedenneGX.ID);
///        LightningTYPE.add(Electrike.ID);
///        LightningTYPE.add(ElectrodeV.ID);
///        LightningTYPE.add(Emolga.ID);
///        LightningTYPE.add(Grubbin.ID);
///        LightningTYPE.add(IronHands.ID);
///        LightningTYPE.add(Mareep.ID);
///        LightningTYPE.add(Minun.ID);
///        LightningTYPE.add(Morpeko.ID);
///        LightningTYPE.add(OricorioLightning.ID);
///        LightningTYPE.add(Pachirisu.ID);
///        LightningTYPE.add(Plusle.ID);
///        LightningTYPE.add(Regieleki.ID);
///        LightningTYPE.add(Spark.ID);
///        LightningTYPE.add(TapuKokoGX.ID);
///        LightningTYPE.add(ThundurusV.ID);
///        LightningTYPE.add(Tynamo.ID);
///        LightningTYPE.add(Voltorb.ID);
///        LightningTYPE.add(Xurkitree.ID);
///        LightningTYPE.add(Zapdos.ID);
///
///        ArrayList<String> FIGHTINGTYPE = new ArrayList<>();
///        FIGHTINGTYPE.add(Bunnelby.ID);
///        FIGHTINGTYPE.add(CoalossalV.ID);
///        FIGHTINGTYPE.add(Falinks.ID);
///        FIGHTINGTYPE.add(FalinksV.ID);
///        FIGHTINGTYPE.add(FightingStadium.ID);
///        FIGHTINGTYPE.add(FocusSash.ID);
///        FIGHTINGTYPE.add(GalarianFarfetchd.ID);
///        FIGHTINGTYPE.add(Gligar.ID);
///        FIGHTINGTYPE.add(HisuianArcanineV.ID);
///        FIGHTINGTYPE.add(Koraidonex.ID);
///        FIGHTINGTYPE.add(Makuhita.ID);
///        FIGHTINGTYPE.add(Mankey.ID);
///        FIGHTINGTYPE.add(Regirock.ID);
///        FIGHTINGTYPE.add(Riolu.ID);
///        FIGHTINGTYPE.add(Silicobra.ID);
///        FIGHTINGTYPE.add(StoneEnergy.ID);
///        FIGHTINGTYPE.add(StrongEnergy.ID);
///        FIGHTINGTYPE.add(Terrakion.ID);
///        FIGHTINGTYPE.add(UrsalunaV.ID);
///        FIGHTINGTYPE.add(ZamazentaV.ID);
///
///        ArrayList<String> FIRETYPE = new ArrayList<>();
///        FIRETYPE.add(CentiskorchV.ID);
///        FIRETYPE.add(CharizardV.ID);
///        FIRETYPE.add(InciniroarV.ID);
///        FIRETYPE.add(InfernapeV.ID);
///        FIRETYPE.add(Magmar.ID);
///        FIRETYPE.add(Numel.ID);
///        FIRETYPE.add(OricorioFire.ID);
///        FIRETYPE.add(Pansear.ID);
///        FIRETYPE.add(Ponyta.ID);
///        FIRETYPE.add(Slugma.ID);
///        FIRETYPE.add(Torchic.ID);
///        FIRETYPE.add(Victini.ID);
///        FIRETYPE.add(VolcaronaV.ID);
///        FIRETYPE.add(Vulpix.ID);
///        FIRETYPE.add(Welder.ID);
///
///        ArrayList<String> GRASSTYPE = new ArrayList<>();
///        GRASSTYPE.add(AromaticEnergy.ID);
///        GRASSTYPE.add(Cacnea.ID);
///        GRASSTYPE.add(Calyrex.ID);
///        GRASSTYPE.add(Capaskid.ID);
///        GRASSTYPE.add(ChesnaughtV.ID);
///        GRASSTYPE.add(Durant.ID);
///        GRASSTYPE.add(Dwebble.ID);
///        GRASSTYPE.add(HisuianLilligantV.ID);
///        GRASSTYPE.add(Maractus.ID);
///        GRASSTYPE.add(Morelull.ID);
///        GRASSTYPE.add(Nincada.ID);
///        GRASSTYPE.add(Oddish.ID);
///        GRASSTYPE.add(Paras.ID);
///        GRASSTYPE.add(Phantump.ID);
///        GRASSTYPE.add(Pinsir.ID);
///        GRASSTYPE.add(Pheromosa.ID);
///        GRASSTYPE.add(Revitalizer.ID);
///        GRASSTYPE.add(Scyther.ID);
///        GRASSTYPE.add(Shroomish.ID);
///        GRASSTYPE.add(Tangela.ID);
///        GRASSTYPE.add(Tropius.ID);
///        GRASSTYPE.add(VenusaurEX.ID);
///        GRASSTYPE.add(VileplumeGX.ID);
///
///        ArrayList<String> STEELTYPE = new ArrayList<>();
///        STEELTYPE.add(AlolanDiglet.ID);
///        STEELTYPE.add(Aron.ID);
///        STEELTYPE.add(Bronzor.ID);
///        STEELTYPE.add(Celesteela.ID);
///        STEELTYPE.add(CoatingEnergy.ID);
///        STEELTYPE.add(CopperajahV.ID);
///        STEELTYPE.add(CrystalCave.ID);
///        STEELTYPE.add(Drilbur.ID);
///        STEELTYPE.add(Duraludon.ID);
///        STEELTYPE.add(Ferroseed.ID);
///        STEELTYPE.add(GalarianPerrserkerV.ID);
///        STEELTYPE.add(GalarianStunfiskV.ID);
///        STEELTYPE.add(GenesectV.ID);
///        STEELTYPE.add(Gimmighoul.ID);
///        STEELTYPE.add(Heatran.ID);
///        STEELTYPE.add(Honedge.ID);
///        STEELTYPE.add(KartanaGX.ID);
///        STEELTYPE.add(Klefki.ID);
///        STEELTYPE.add(Magnemite.ID);
///        STEELTYPE.add(MetagrossEX.ID);
///        STEELTYPE.add(MetalCoreBarrier.ID);
///        STEELTYPE.add(MtCoronet.ID);
///        STEELTYPE.add(Nosepass.ID);
///        STEELTYPE.add(Orthworm.ID);
///        STEELTYPE.add(RadiantSteelix.ID);
///        STEELTYPE.add(Scizor.ID);
///        STEELTYPE.add(ShieldEnergy.ID);
///        STEELTYPE.add(Skarmory.ID);
///        STEELTYPE.add(Zamazenta.ID);
///
///        ArrayList<String> PSYCHICTYPE = new ArrayList<>();
///        PSYCHICTYPE.add(Blacephalon.ID);
///        PSYCHICTYPE.add(DeoxysD.ID);
///        PSYCHICTYPE.add(DeoxysA.ID);
///        PSYCHICTYPE.add(DeoxysS.ID);
///        PSYCHICTYPE.add(GalarianArticuno.ID);
///        PSYCHICTYPE.add(Gastly.ID);
///        PSYCHICTYPE.add(Zubat.ID);
///        PSYCHICTYPE.add(Giratina.ID);
///        PSYCHICTYPE.add(HorrorEnergy.ID);
///        PSYCHICTYPE.add(LostCity.ID);
///        PSYCHICTYPE.add(Meditite.ID);
///        PSYCHICTYPE.add(MewEX.ID);
///        PSYCHICTYPE.add(MirageGate.ID);
///        PSYCHICTYPE.add(Munna.ID);
///        PSYCHICTYPE.add(Natu.ID);
///        PSYCHICTYPE.add(Nihilego.ID);
///        PSYCHICTYPE.add(RotomV.ID);
///        PSYCHICTYPE.add(Sableye.ID);
///        PSYCHICTYPE.add(Shuppet.ID);
///        PSYCHICTYPE.add(Sigilyph.ID);
///        PSYCHICTYPE.add(Trubbish.ID);
///
///
///        for (int s : set) {
///            if (s == 1) {
///                for (String j : PSYCHICTYPE) {
///                    AbstractDungeon.commonCardPool.removeCard(j);
///                    AbstractDungeon.uncommonCardPool.removeCard(j);
///                    AbstractDungeon.rareCardPool.removeCard(j);
///                    AbstractDungeon.srcCommonCardPool.removeCard(j);
///                    AbstractDungeon.srcUncommonCardPool.removeCard(j);
///                    AbstractDungeon.srcRareCardPool.removeCard(j);
///                }
///            }
///        }
///        for (int s : set) {
///            if (s == 2) {
///                for (String e : STEELTYPE) {
///                    AbstractDungeon.commonCardPool.removeCard(e);
///                    AbstractDungeon.uncommonCardPool.removeCard(e);
///                    AbstractDungeon.rareCardPool.removeCard(e);
///                    AbstractDungeon.srcCommonCardPool.removeCard(e);
///                    AbstractDungeon.srcUncommonCardPool.removeCard(e);
///                    AbstractDungeon.srcRareCardPool.removeCard(e);
///                }
///            }
///        }
///        for (int s : set) {
///            if (s == 3) {
///                for (String F : FIRETYPE) {
///                    AbstractDungeon.commonCardPool.removeCard(F);
///                    AbstractDungeon.uncommonCardPool.removeCard(F);
///                    AbstractDungeon.rareCardPool.removeCard(F);
///                    AbstractDungeon.srcCommonCardPool.removeCard(F);
///                    AbstractDungeon.srcUncommonCardPool.removeCard(F);
///                    AbstractDungeon.srcRareCardPool.removeCard(F);
///                }
///            }
///        }
///        for (int s : set) {
///            if (s == 4) {
///                for (String G : FIGHTINGTYPE) {
///                    AbstractDungeon.commonCardPool.removeCard(G);
///                    AbstractDungeon.uncommonCardPool.removeCard(G);
///                    AbstractDungeon.rareCardPool.removeCard(G);
///                    AbstractDungeon.srcCommonCardPool.removeCard(G);
///                    AbstractDungeon.srcUncommonCardPool.removeCard(G);
///                    AbstractDungeon.srcRareCardPool.removeCard(G);
///                }
///            }
///        }
///        for (int s : set) {
///            if (s == 5) {
///                for (String H : GRASSTYPE) {
///                    AbstractDungeon.commonCardPool.removeCard(H);
///                    AbstractDungeon.uncommonCardPool.removeCard(H);
///                    AbstractDungeon.rareCardPool.removeCard(H);
///                    AbstractDungeon.srcCommonCardPool.removeCard(H);
///                    AbstractDungeon.srcUncommonCardPool.removeCard(H);
///                    AbstractDungeon.srcRareCardPool.removeCard(H);
///                }
///            }
///        }
///        for (int s : set) {
///            if (s == 6) {
///                for (String L : LightningTYPE) {
///                    AbstractDungeon.commonCardPool.removeCard(L);
///                    AbstractDungeon.uncommonCardPool.removeCard(L);
///                    AbstractDungeon.rareCardPool.removeCard(L);
///                    AbstractDungeon.srcCommonCardPool.removeCard(L);
///                    AbstractDungeon.srcUncommonCardPool.removeCard(L);
///                    AbstractDungeon.srcRareCardPool.removeCard(L);
///                }
///            }
///        }
///    }
///}