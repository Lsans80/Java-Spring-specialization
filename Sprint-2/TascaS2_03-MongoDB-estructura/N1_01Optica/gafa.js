
db.createCollection( 'gafa', {validator: {$jsonSchema: {bsonType: 'object',title:'gafa',required: [         'idProveedor'],properties: {marca: {bsonType: 'string'},graduacionIzquierdo: {bsonType: 'string'},graduacionDerecho: {bsonType: 'string'},colorMontura: {bsonType: 'string'},colorCristal: {bsonType: 'string'},precio: {bsonType: 'double'},idProveedor: {bsonType: 'objectId'}}         }      }});  