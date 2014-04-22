

<div id="Meldi" class="invisible">
	<div id="meldi_container">
		<div id="navi-buttons">
			<button id="navi-buttons-meldi" class="navi-buttons-placement" onclick="showMeldi();">Meldi</button>
			<button id="navi-buttons-registreeri" class="navi-buttons-placement" onclick="showRegistreeru();">Registreeru</button>
		</div>
		<div id="meld">
			<h3>Meldi</h3>
			<div id="meldi_integr">
				<form id="meldi-vorm" method="post" action="login">
					Kasutajanimi: <input class="input-field" name="k-nimi" placeholder="Kasutajanimi" type="text">
					Parool: <input class="input-field" name="pwd" placeholder="******" type="password">
					<span class="hidden-nupud">
						<button onclick="makeHidden('Meldi');">Meldi</button>
					</span>
				</form>
				<button onclick="makeHidden('Meldi');">Katkesta</button>
			</div>
			<div id="meldi_v�line">
				<div class="fb-login-button" data-max-rows="1" data-size="large" data-show-faces="true" data-auto-logout-link="true"></div>
			</div>
		</div>
		<div id="register">
			<h3>Registreeru</h3>
			<form id="registreeru-vorm" method="post" action="register">
				Eesnimi: <input class="input-field" name="e-nimi" placeholder="Eesnimi" type="text">
				Perenimi: <input class="input-field" name="p-nimi" placeholder="Perenimi" type="text">
				Kasutajanimi: <input class="input-field" name="k-nimi" placeholder="Kasutajanimi" type="text">
				Parool: <input class="input-field" name="pwd" placeholder="******" type="password">
				Parool uuesti: <input class="input-field" name="pwd2" placeholder="******" type="password">
				<span class="hidden-nupud">
					<button onclick="makeHidden('Meldi');">Registreeru</button>
				</span>
			</form>
			<button onclick="makeHidden('Meldi');">Katkesta</button>
		</div>
	</div>

</div>