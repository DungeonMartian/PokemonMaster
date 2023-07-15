package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
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

public class Cramorant extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Cramorant",
            3,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 16;
    private static final int UPG_DAMAGE = 4;



    public Cramorant() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.WATER);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackWater.png","pokemonmaster/character/cardback/bg_attackWater_p.png");

    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));

    }

    //@Override
    //public void update() {
    //    if (AbstractDungeon.player.exhaustPile.size() >=4){
    //        this.cost =0;
    //        this.costForTurn =0;
    //        this.isCostModified=true;
    //    }
    //    if (AbstractDungeon.player.exhaustPile.size() <=3){
    //        this.cost =3;
    //        this.costForTurn =3;
    //        this.isCostModified=false;
    //    }
    //    super.update();
    //}
    @Override
    public void calculateCardDamage(AbstractMonster mo) {
        if (AbstractDungeon.player.exhaustPile.size() >=4){
            this.cost =0;
            this.costForTurn =0;
            this.isCostModified=true;
        }
        if (AbstractDungeon.player.exhaustPile.size() <=3){
            this.cost =3;
            this.costForTurn =3;
            this.isCostModified=false;
        }
        super.calculateCardDamage(mo);
    }
    @Override
    public void applyPowers() {
        if (AbstractDungeon.player.exhaustPile.size() >=4){
            this.cost =0;
            this.costForTurn =0;
            this.isCostModified=true;
        }
        if (AbstractDungeon.player.exhaustPile.size() <=3){
            this.cost =3;
            this.costForTurn =3;
            this.isCostModified=false;
        }
        super.applyPowers();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Cramorant();
    }
}

