
db.createCollection( 'Paypal', {validator: {$jsonSchema: {bsonType: 'object',title:'Paypal',required: [         'nombrePaypal'],properties: {nombrePaypal: {bsonType: 'string'}}         }      }});  