# README #

Create an application at https://apps.twitter.com/

Save the consumer key and consumer secret in a secret place

Create a rest request to /oauth2/token to get the bearer token using your consumer key and secret. Follow the steps in here https://dev.twitter.com/oauth/application-only

Once you have your bearer token use it get data from twitter.

Parse this data using jackson and obtain the hashtags for a particular location.

**Basic Test**

create a topic in kafka and push these tags into it, later gather these tags using the consumer and make a count of the tags for a particular created time.

Advanced

Create a topic if does not exits using Admin Utils and zkUtils.
Delete a topic if exits using Admin Utils and zkUtils


send any questions to chandrahasjava21@gmail.com