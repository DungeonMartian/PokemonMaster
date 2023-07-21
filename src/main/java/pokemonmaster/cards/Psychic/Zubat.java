package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
// import com.megacrit.cardcrawl.cards.AbstractCard.CardRarity;
// import com.megacrit.cardcrawl.cards.AbstractCard.CardTarget;
// import com.megacrit.cardcrawl.cards.AbstractCard.CardType;
import com.megacrit.cardcrawl.actions.utility.DiscardToHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
// import pokemonmaster.cards.PokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Zubat extends BasicPokemonCard {
// public class Zubat extends PokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Zubat",
            0,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 4;
    private static final int UPG_DAMAGE = 2;



    public Zubat() {
        super(cardInfo, new Golbat(), new Crobat(), CustomTags.PSYCHIC);
        // super(cardInfo, new Natu(), new Xatu(), CustomTags.PSYCHIC);
        // super(cardInfo, CustomTags.PSYCHIC);
        setDamage(DAMAGE, UPG_DAMAGE);
        // tags.add(CustomTags.PSYCHIC);
        // tags.add(CustomTags.POKEMON);
        // tags.add(CustomTags.UNEVOLVED);
        // setEthereal(true);
        // purgeOnUse = true;
        // this.cardsToPreview = new Crobat();
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
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.POISON));
        // addToBot(new MakeTempCardInDiscardAction(new Golbat(), 1));
        }
}

