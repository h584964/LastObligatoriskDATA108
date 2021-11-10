
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input id="fornavn" type="text"
					name="fornavn" value="${skjema.fornavn}" /> 
					<font color="red">${skjema.feilFornavn}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input id="etternavn" type="text"
					name="etternavn" value="${skjema.etternavn}" /> 
					<font color="red"> ${skjema.feilEtternavn}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input id="mobil" type="text"
					name="mobil" value="${skjema.mobil}" /> 
					<font color="red">${skjema.feilMobil}</font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input id="passord" type="text"
					name="passord" value="${skjema.passord}" /> 
					<font color="red">${skjema.feilPassord}</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input id="passordRepetert"
					type="text" name="passordRe"
					value="${skjema.passordRe}" /> 
					<font color="red">${skjema.feilPassordRe}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> <input id="kjonn" type="radio" name="kjonn"
					value="mann"
					 />mann
				<input type="radio" name="kjonn" value="kvinne"
					 />kvinne
				<font color="red">${skjema.feilKjonn}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
		</fieldset>
	</form>
	
	<p>Hvis du allerde er påmeldt -->  <a href="login">Trykk her.</a></p>
	
</body>
</html>