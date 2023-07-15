package pokemonmaster.cards.Dark;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.powers.Spark;
import pokemonmaster.util.CardInfo;

import java.util.function.Predicate;

import static pokemonmaster.PokemonMasterMod.makeID;

public class EternatusV extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "EternatusV",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 12;
    private static final int UPG_DAMAGE = 6;



    public EternatusV() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.DARK);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackDark.png","pokemonmaster/character/cardback/bg_attackDark_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new SelectCardsInHandAction(1, "Exhaust.", false, true, (Predicate<AbstractCard>) card -> true, abstractCards -> {
            for (AbstractCard i : abstractCards) {
                if (i.cost >0) {
                    addToBot(new ApplyPowerAction(p, p, new Spark(p, i.cost)));
                }
                addToBot(new ExhaustSpecificCardAction(i,p.hand,true));

            }
        }));
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));

    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new EternatusV();
    }
}

