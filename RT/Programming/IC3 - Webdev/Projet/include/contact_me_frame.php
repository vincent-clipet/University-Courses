<div class="content">
	<div id="contact_me">

		<form method="post" action="contact_me_action.php">
			<fieldset>
				<legend>Formulaire de contact</legend>
				<br />
				<input type="radio" name="sexe" id="homme" value="homme" /> <label for="homme">Mr.</label>
				<input type="radio" name="sexe" id="femme" value="femme" /> <label for="femme">Mme.</label>
				<br />
				<label for="nom">Nom</label> : <input type="text" name="nom" id="nom" />
				<br />
				<label for="prenom">Prénom</label> : <input type="text"	name="prenom" id="prenom" value="" />
				<br />
				<br />
				<label for="description">Message</label> :
				<br />
				<input type="text" size="50" name="objet" id="objet" value="Objet : " />
				<br />
				<textarea rows="10" cols="50" name="message" id="message">...</textarea>
				<br />
				<br />
				<label for="soumission"></label><input type="submit" name="soumission" id="soumission" />
				<label for="init"></label><input type="reset" name="init" id="init" />
			</fieldset>
		</form>

	</div>
</div>
