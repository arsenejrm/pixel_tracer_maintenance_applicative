#include "id.h"
/*
 * FR : Identifiant global utilisé pour générer des IDs uniques.
 * EN : Global identifier used to generate unique IDs.
 */
static unsigned long long int global_id = 0;
/**
 * FR : Génère et retourne un nouvel ID unique.
 * EN : Generates and returns a new unique ID.
 */
unsigned long long int get_next_id() {
    global_id++;
    return global_id;
}
/**
 * FR : Définit manuellement la valeur de l'ID global.
 * EN : Manually sets the global ID value.
 */
void set_id(unsigned long long int id) {
    global_id = id;
}

/**
 * FR : Sauvegarde l'ID global dans un fichier.
 * EN : Saves the global ID to a file.
 * TODO : implémentation
 */
void save_id() {
    // todo save id in file ID_FILE
}

/**
 * FR : Charge l'ID global depuis un fichier.
 * EN : Loads the global ID from a file.
 * TODO : implémentation
 */
void load_id() {
    // todo load id from file ID_FILE
}
