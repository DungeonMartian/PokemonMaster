package pokemonmaster.cards.Dragon;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Axew extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Axew",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);
    private boolean ISELITE = false;



    public Axew() {
        super(cardInfo,new Fraxure(),new Haxorus(),CustomTags.DRAGON);
        ISELITE = false;
        setCostUpgrade(0);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDragon.png","pokemonmaster/character/cardback/bg_skillDragon_p.png");



    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        for (AbstractMonster j : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
            if (j.type == AbstractMonster.EnemyType.BOSS || j.type == AbstractMonster.EnemyType.ELITE) {
                ISELITE = true;
            }

        }
        if (ISELITE) {
            AbstractCard P = new Fraxure();
            if (this.upgraded) {
                P.upgrade();


            }
            addToBot(new MakeTempCardInHandAction(P, 1));

        }

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Axew();
    }
}

