package pokemonmaster.cards.Base;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.FleetingField;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.vfx.combat.SmokeBombEffect;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class EscapeRope extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "EscapeRope",
            3,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);
    public static final String ID = makeID(cardInfo.baseId);
    public EscapeRope() {
        super(cardInfo);
        tags.add(CardTags.HEALING);

    }
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        boolean canUse = super.canUse(p, m);
        if (!canUse)
            return false;
        for (AbstractMonster j : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
        if (j.type == AbstractMonster.EnemyType.BOSS) {
            return false;
        }
        }
        return canUse;
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

            if ((AbstractDungeon.getCurrRoom()).phase == AbstractRoom.RoomPhase.COMBAT) {
                (AbstractDungeon.getCurrRoom()).smoked = true;
                addToBot(new VFXAction(new SmokeBombEffect(p.hb.cX, p.hb.cY)));
                AbstractDungeon.player.hideHealthBar();
                AbstractDungeon.player.isEscaping = true;
                AbstractDungeon.player.flipHorizontal = !AbstractDungeon.player.flipHorizontal;
                AbstractDungeon.overlayMenu.endTurnButton.disable();
                AbstractDungeon.player.escapeTimer = 2.5F;
                FleetingField.fleeting.set(this, true);
                if (this.upgraded) {
                    addToBot(new AddCardToDeckAction(new EscapeRope()));
                }
            }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new EscapeRope();
    }
}

