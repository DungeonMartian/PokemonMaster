package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Sableye extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Sableye",
            0,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 30;
    private static final int UPG_DAMAGE = 10;



    public Sableye() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.PSYCHIC);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackPsychic.png","pokemonmaster/character/cardback/bg_attackPsychic_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int EXHAUST = p.exhaustPile.size();
        if (EXHAUST >= 10) {
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        }
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Sableye();
    }
}

