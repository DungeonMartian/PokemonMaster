package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Natu extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Natu",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGICD = 2;
    private static final int UPG_MAGICD = 1;

    public Natu() {
        super(cardInfo);
        setMagic(MAGICD, UPG_MAGICD);
        tags.add(CustomTags.PSYCHIC);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        purgeOnUse = true;
        this.cardsToPreview = new Xatu();
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackPsychic.png","pokemonmaster/character/cardback/bg_attackPsychic_p.png");

    }
    @Override
    public float calculateModifiedCardDamage(AbstractPlayer player, AbstractMonster mo, float tmp) {
        if (player.exhaustPile.size() >0) {
            int EXHAUST =player.exhaustPile.size();
            this.rawDescription = cardStrings.DESCRIPTION;
            this.baseDamage = EXHAUST * this.magicNumber;
            this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
            initializeDescription();
        }
        return super.calculateModifiedCardDamage(player, mo, tmp);
    }

    @Override
    public void applyPowers() {
        if (AbstractDungeon.player.exhaustPile.size() >0) {
            int EXHAUST =AbstractDungeon.player.exhaustPile.size();
            this.rawDescription = cardStrings.DESCRIPTION;
            this.baseDamage = EXHAUST * this.magicNumber;
            this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
            initializeDescription();
        }
        super.applyPowers();
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {


        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        AbstractCard s = (new Xatu()).makeCopy();
        if (this.upgraded) {
            s.upgrade();
        }
        addToBot(new MakeTempCardInDiscardAction(s,1));
    }
    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
    }
    public void upgrade() {

        this.cardsToPreview.upgrade();

        super.upgrade();
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Natu();
    }
}

