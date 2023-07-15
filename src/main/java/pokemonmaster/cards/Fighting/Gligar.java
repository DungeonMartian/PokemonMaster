package pokemonmaster.cards.Fighting;

import com.evacipated.cardcrawl.mod.stslib.actions.common.StunMonsterAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Gligar extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Gligar",
            3,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int POISOND = 7;
    private static final int POISONDUP = 2;



    public Gligar() {
        super(cardInfo);
        setMagic(POISOND, POISONDUP);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        tags.add(CustomTags.FIGHTING);
        purgeOnUse = true;
        this.cardsToPreview = new Gliscor();
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFighting.png","pokemonmaster/character/cardback/bg_skillFighting_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(m, p, new PoisonPower(m, p, this.magicNumber), this.magicNumber, AbstractGameAction.AttackEffect.POISON));
        addToBot(new StunMonsterAction(m,p ));
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(new Gliscor(), 1));

    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Gligar();
    }
}

