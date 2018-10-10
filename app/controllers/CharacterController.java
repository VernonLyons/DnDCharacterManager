package controllers;

import models.GameCharacter;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class CharacterController extends Controller
{
    private FormFactory formFactory;
    private JPAApi jpaApi;

    @Inject
    public CharacterController (FormFactory formFactory, JPAApi jpaApi)
    {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    @Transactional
    public Result getCharacter(int characterId)
    {
        String sql = "SELECT c FROM GameCharacter c WHERE characterId = :characterId";

        GameCharacter gameCharacter = jpaApi.em().createQuery(sql, GameCharacter.class).setParameter("characterId", characterId).getSingleResult();

        return ok(views.html.character.render(gameCharacter));
    }
}
