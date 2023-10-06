package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.utility.DiscardToHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;
import pokemonmaster.cards.Base.Toxin;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Crobat extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Crobat",
            0,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 7;
    private static final int UPG_DAMAGE = 3;
    private static final int POISOND = 5;
    private static final int POISONDUP = 3;



    public Crobat() {
        super(cardInfo, CustomTags.PSYCHIC);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(POISOND, POISONDUP);
        // tags.add(CustomTags.PSYCHIC);
        //this.cardsToPreview = new Toxin();
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackPsychic.png","pokemonmaster/character/cardback/bg_attackPsychic_p.png");

    }
    @Override
    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        super.onPlayCard(c, m);
        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() != 0){
            if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() % 5 == 0) {
                addToBot(new DiscardToHandAction(this));
            }
        }
    }
    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(m, p, new PoisonPower(m, p, this.magicNumber), this.magicNumber, AbstractGameAction.AttackEffect.POISON));
        addToBot(new MakeTempCardInDiscardAction(new Toxin(), 1));
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Crobat();
    }
}

