package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.EvolveActionCombat;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Bunnelby extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Bunnelby",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 12;
    private static final int UPG_DAMAGE = 6;



    public Bunnelby() {
        super(cardInfo,new Diggersby(),new Diggersby(),CustomTags.FIGHTING);
        setDamage(DAMAGE, UPG_DAMAGE);

        tags.add(CardTags.STRIKE);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFighting.png","pokemonmaster/character/cardback/bg_attackFighting_p.png");
    }




    public void use(AbstractPlayer p, AbstractMonster m) {


            }

    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new VulnerablePower(p,2,false)));

        //AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(new Diggersby(), 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Bunnelby();
    }
}

