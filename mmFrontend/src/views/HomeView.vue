<template>
  <main class="flex h-full flex-col">
    <HeaderBlock />
    <div class="bg-white">
      <div>
        <!-- Mobile filter dialog -->
        <TransitionRoot as="template" :show="mobileFiltersOpen">
          <Dialog class="relative z-40 lg:hidden" @close="mobileFiltersOpen = false">
            <TransitionChild
              as="template"
              enter="transition-opacity ease-linear duration-300"
              enter-from="opacity-0"
              enter-to="opacity-100"
              leave="transition-opacity ease-linear duration-300"
              leave-from="opacity-100"
              leave-to="opacity-0"
            >
              <div class="fixed inset-0 bg-black/25" />
            </TransitionChild>

            <div class="fixed inset-0 z-40 flex">
              <TransitionChild
                as="template"
                enter="transition ease-in-out duration-300 transform"
                enter-from="translate-x-full"
                enter-to="translate-x-0"
                leave="transition ease-in-out duration-300 transform"
                leave-from="translate-x-0"
                leave-to="translate-x-full"
              >
                <DialogPanel
                  class="relative ml-auto flex size-full max-w-xs flex-col overflow-y-auto bg-white py-4 pb-12 shadow-xl"
                >
                  <div class="flex items-center justify-between px-4">
                    <h2 class="text-lg font-medium text-gray-900">Filters</h2>
                    <button
                      type="button"
                      class="-mr-2 flex size-10 items-center justify-center rounded-md bg-white p-2 text-gray-400"
                      @click="mobileFiltersOpen = false"
                    >
                      <span class="sr-only">Close menu</span>
                      <XMarkIcon class="size-6" aria-hidden="true" />
                    </button>
                  </div>

                  <!-- Filters -->
                  <form class="mt-4 border-t border-gray-200">
                    <h3 class="sr-only">Categories</h3>
                    <ul role="list" class="px-2 py-3 font-medium text-gray-900">
                      <li v-for="category in subCategories" :key="category.name">
                        <a :href="category.href" class="block px-2 py-3">{{
                          category.name
                        }}</a>
                      </li>
                    </ul>

                    <Disclosure
                      as="div"
                      v-for="section in filters"
                      :key="section.id"
                      class="border-t border-gray-200 px-4 py-6"
                      v-slot="{ open }"
                    >
                      <h3 class="-mx-2 -my-3 flow-root">
                        <DisclosureButton
                          class="flex w-full items-center justify-between bg-white px-2 py-3 text-gray-400 hover:text-gray-500"
                        >
                          <span class="font-medium text-gray-900">{{
                            section.name
                          }}</span>
                          <span class="ml-6 flex items-center">
                            <PlusIcon v-if="!open" class="size-5" aria-hidden="true" />
                            <MinusIcon v-else class="size-5" aria-hidden="true" />
                          </span>
                        </DisclosureButton>
                      </h3>
                      <DisclosurePanel class="pt-6">
                        <div class="space-y-6">
                          <div
                            v-for="(option, optionIdx) in section.options"
                            :key="option.value"
                            class="flex items-center"
                          >
                            <input
                              :id="`filter-mobile-${section.id}-${optionIdx}`"
                              :name="`${section.id}[]`"
                              :value="option.value"
                              type="checkbox"
                              v-model="selectedFilters[section.id]"
                              class="size-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500"
                            />
                            <label
                              :for="`filter-mobile-${section.id}-${optionIdx}`"
                              class="ml-3 min-w-0 flex-1 text-gray-500"
                              >{{ option.label }}</label
                            >
                          </div>
                        </div>
                      </DisclosurePanel>
                    </Disclosure>
                  </form>
                </DialogPanel>
              </TransitionChild>
            </div>
          </Dialog>
        </TransitionRoot>

        <main class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
          <div
            class="flex items-baseline justify-between border-b border-gray-200 pb-6 pt-2"
          >
            <h1 class="text-4xl font-bold tracking-tight text-gray-900">
              Bring a Smile to Someone's Face
            </h1>

            <div class="flex items-center">
              <Menu as="div" class="relative inline-block text-left">
                <transition
                  enter-active-class="transition ease-out duration-100"
                  enter-from-class="transform opacity-0 scale-95"
                  enter-to-class="transform opacity-100 scale-100"
                  leave-active-class="transition ease-in duration-75"
                  leave-from-class="transform opacity-100 scale-100"
                  leave-to-class="transform opacity-0 scale-95"
                >
                  <MenuItems
                    class="absolute right-0 z-10 mt-2 w-40 origin-top-right rounded-md bg-white shadow-2xl ring-1 ring-black/5 focus:outline-none"
                  >
                    <div class="py-1">
                      <MenuItem
                        v-for="option in sortOptions"
                        :key="option.name"
                        v-slot="{ active }"
                      >
                        <a
                          :href="option.href"
                          :class="[
                            option.current
                              ? 'font-medium text-gray-900'
                              : 'text-gray-500',
                            active ? 'bg-gray-100 outline-none' : '',
                            'block px-4 py-2 text-sm',
                          ]"
                          >{{ option.name }}</a
                        >
                      </MenuItem>
                    </div>
                  </MenuItems>
                </transition>
              </Menu>
              <button
                type="button"
                class="-m-2 ml-4 p-2 text-gray-400 hover:text-gray-500 sm:ml-6 lg:hidden"
                @click="mobileFiltersOpen = true"
              >
                <span class="sr-only">Filters</span>
                <FunnelIcon class="size-5" aria-hidden="true" />
              </button>
            </div>
          </div>

          <section aria-labelledby="products-heading" class="pb-24 pt-6">
            <h2 id="products-heading" class="sr-only">Products</h2>

            <div class="grid grid-cols-1 gap-x-8 gap-y-10 lg:grid-cols-4">
              <!-- Filters -->
              <form class="hidden lg:block">
                <h3 class="text-md font-bold text-gray-900 pb-2">Your Location</h3>
                <div>
                  <label for="email" class="sr-only">Email</label>
                  <input type="email" name="email" id="email" class="block w-full rounded-md border-0 py-1.5 px-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm/6" placeholder="Musterstraße 10" />
                </div>
                <Disclosure
                  as="div"
                  v-for="section in filters"
                  :key="section.id"
                  class="border-b border-gray-200 py-6"
                  v-slot="{ open }"
                >
                  <h3 class="-my-3 flow-root">
                    <DisclosureButton
                      class="flex w-full items-center justify-between bg-white py-3 text-sm text-gray-400 hover:text-gray-500"
                    >
                      <span class="font-medium text-gray-900">{{ section.name }}</span>
                      <span class="ml-6 flex items-center">
                        <PlusIcon v-if="!open" class="size-5" aria-hidden="true" />
                        <MinusIcon v-else class="size-5" aria-hidden="true" />
                      </span>
                    </DisclosureButton>
                  </h3>
                  <DisclosurePanel class="pt-6">
                    <div class="space-y-4">
                      <div
                        v-for="(option, optionIdx) in section.options"
                        :key="option.value"
                        class="flex items-center"
                      >
                        <input
                          :id="`filter-${section.id}-${optionIdx}`"
                          :name="`${section.id}[]`"
                          :value="option.value"
                          type="checkbox"
                          v-model="selectedFilters[section.id]"
                          @change="
                            handleFilterChange(
                              section.id,
                              option.value,
                              $event.target.checked
                            )
                          "
                          class="size-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500"
                        />
                        <label
                          :for="`filter-${section.id}-${optionIdx}`"
                          class="ml-3 text-sm text-gray-600"
                          >{{ option.label }}</label
                        >
                      </div>
                    </div>
                  </DisclosurePanel>
                </Disclosure>
              </form>

              <!-- Product grid -->
              <div class="lg:col-span-3">
                <!-- Your content -->
                <div id="map">
                  <l-map
                    ref="map"
                    v-model:zoom="zoom"
                    v-model:center="center"
                    :useGlobalLeaflet="false"
                  >
                    <l-tile-layer
                      url="https://tiles.stadiamaps.com/tiles/outdoors/{z}/{x}/{y}{r}.png"
                      layer-type="base"
                      name="Stadia Maps Basemap"
                    ></l-tile-layer>
                    <l-marker
                      v-for="(arcade, index) in filteredArcades"
                      :key="index"
                      :lat-lng="[arcade.lat, arcade.lon]"
                    >
                      <l-popup>
                        <PopupContent
                          :title="arcade.name"
                          :description="arcade.description"
                        />
                      </l-popup>
                    </l-marker>
                  </l-map>
                </div>
                

            <!-- upcoming -->
            <div class="border-b border-gray-200 py-4">
              <Disclosure>
                <template #default="{ open }">
                  <DisclosureButton
                    class="flex justify-between items-center w-full bg-white py-3 text-lg font-medium text-gray-900 hover:bg-gray-50 rounded-md px-4">
                    <span>Your Upcoming Events</span>
                    <ChevronDownIcon :class="{ 'rotate-180': open, 'rotate-0': !open }"
                      class="h-5 w-5 transition-transform duration-300" />
                  </DisclosureButton>
                  <DisclosurePanel>
                    <ul class="space-y-4 pt-4">
                      <li v-for="event in upcomingEvents" :key="event.id"
                        class="border rounded-lg p-4 bg-gray-50 shadow-sm hover:shadow-md transition-shadow">
                        <h3 class="text-lg font-semibold">{{ event.name }}</h3>
                        <p class="text-gray-600">Date: {{ event.date }}</p>
                        <p class="text-gray-600">Location: {{ event.location }}</p>
                      </li>
                    </ul>
                  </DisclosurePanel>
                </template>
              </Disclosure>
            </div>
              </div>
            </div>
          </section>
        </main>
      </div>
    </div>
  </main>
</template>

<script setup>
import HeaderBlock from "@/components/HeaderBlock.vue";
import PopupContent from "@/components/PopupContent.vue";

import {
  Dialog,
  DialogPanel,
  Disclosure,
  DisclosureButton,
  DisclosurePanel,
  Menu,
  MenuButton,
  MenuItem,
  MenuItems,
  TransitionChild,
  TransitionRoot,
} from "@headlessui/vue";
import { XMarkIcon } from "@heroicons/vue/24/outline";
import {
  ChevronDownIcon,
  FunnelIcon,
  MinusIcon,
  PlusIcon,
  Squares2X2Icon,
} from "@heroicons/vue/20/solid";

import { ref, reactive, watch, onMounted } from "vue";
import "leaflet/dist/leaflet.css";
import { LMap, LTileLayer, LMarker, LPopup } from "@vue-leaflet/vue-leaflet";

//mock events
const upcomingEvents = ref([
  { id: 1, name: 'Pride Parade', date: '2024-12-05', location: 'Community Hall' },
  { id: 2, name: 'Baking Hour', date: '2024-12-12', location: 'Kitchen Studio' }
]);

const selectedFilters = reactive({
  categories: [],
  availability: [],
  interestFields: [],
  languages: [],
  accessibility: [],
});
const filteredArcades = ref([]);

let zoom = ref(11);
let center = ref([48.1351, 11.582]);

const arcades = ref([]);

const fetchArcades = async () => {
  try {
    const userEmail = localStorage.getItem('userEmail');
    const response = await fetch(`http://localhost:8080/userEvent/getFiltered/${userEmail}`);
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    arcades.value = await response.json();
    filterArcades();
  } catch (error) {
    console.error('Error fetching arcades:', error);
    arcades.value = [];
  }
};
console.log(filteredArcades);

const filterArcades = () => {
  filteredArcades.value = arcades.value.filter((arcade) => {
    // If all filters are empty, include all arcades
    const noFiltersApplied = Object.values(selectedFilters).every(
      (filter) => filter.length === 0
    );
    if (noFiltersApplied) return true;

    return (
      (selectedFilters.interestFields.length === 0 ||
        selectedFilters.interestFields.some((field) =>
          (arcade.details?.interestFields || [])
            .map((f) => f.toLowerCase())
            .includes(field)
        )) &&
      (selectedFilters.availability.length === 0 ||
        selectedFilters.availability.some((availability) =>
          (arcade.details?.availability || []).includes(availability)
        )) &&
      (selectedFilters.languages.length === 0 ||
        selectedFilters.languages.some((language) =>
          (arcade.details?.languages || []).includes(language)
        )) &&
      (selectedFilters.accessibility.length === 0 ||
        selectedFilters.accessibility.some((access) =>
          (arcade.details?.accessibility || []).includes(access)
        ))
    );
  });
};

watch(
  () => selectedFilters,
  filterArcades,
  { deep: true } // Ensures nested properties are observed
);

// Initialize filters with a default empty structure
const filters = ref([
  {
    id: "categories",
    name: "Categories",
    options: []
  },
  {
    id: "availability",
    name: "Availability",
    options: [
      { value: "1hour", label: "1 hour", checked: false },
      { value: "multiHour", label: "2-3 hours", checked: false },
      { value: "fullDay", label: "Full-day", checked: true },
      { value: "flexible", label: "Flexible", checked: false },
    ],
  },
  {
    id: "interestFields",
    name: "Interests",
    options: []
  },
  {
    id: "languages",
    name: "Languages",
    options: []
  },
  {
    id: "accessibility",
    name: "Accessibility",
    options: [
      { value: "wheelchairFriendly", label: "Wheelchair accessible", checked: false },
      { value: "publicTransport", label: "Public transportation nearby", checked: false },
    ],
  },
]);

const setupFilters = async () => {
  try {
    const userEmail = localStorage.getItem('userEmail');
    if (!userEmail) {
      console.error('No user email found in localStorage');
      return;
    }

    console.log('Fetching data for user:', userEmail); // Debug log

    const response = await fetch(`http://localhost:8080/user/get/${userEmail}`);
    if (!response.ok) throw new Error('Failed to fetch user data');
    
    const userData = await response.json();
    console.log('Received user data:', userData); // Debug log
    
    // Update only the dynamic filters
    filters.value = filters.value.map(filter => {
      if (filter.id === 'categories') {
        console.log('Setting categories from:', userData.preferredTypesOfEvents); // Debug log
        filter.options = userData.preferredTypesOfEvents.map(type => ({
          value: type.toLowerCase(),
          label: type,
          checked: false
        }));
      } else if (filter.id === 'interestFields') {
        console.log('Setting interests from:', userData.interests); // Debug log
        filter.options = userData.interests.map(interest => ({
          value: interest.toLowerCase(),
          label: interest,
          checked: false
        }));
      } else if (filter.id === 'languages') {
        console.log('Setting languages from:', userData.languagues); // Debug log
        filter.options = userData.languagues.map(lang => ({
          value: lang.toLowerCase(),
          label: lang,
          checked: false
        }));
      }
      return filter;
    });

    console.log('Final filters structure:', filters.value); // Debug log
  } catch (error) {
    console.error('Error fetching user data:', error);
  }
};

const mobileFiltersOpen = ref(false);

const resetFilters = () => {
  Object.keys(selectedFilters).forEach((key) => {
    selectedFilters[key] = [];
  });
};

// Add these refs/functions after other refs
const showPreferencesPopup = ref(false);

// Function to check if preferences exist
const checkPreferences = () => {
  const preferences = localStorage.getItem("preferences");
  if (!preferences) {
    showPreferencesPopup.value = true;
  }
};

// Function to save preferences
const savePreferences = (preferencesData) => {
  localStorage.setItem("preferences", JSON.stringify(preferencesData));
  showPreferencesPopup.value = false;
};

// Function to close popup
const closePreferencesPopup = () => {
  showPreferencesPopup.value = false;
};

// Add this to your existing onMounted
onMounted(() => {
  resetFilters();
  checkPreferences();
  fetchArcades();
  setupFilters();
});

// Add this to debug filter changes
watch(
  selectedFilters,
  (newValue) => {
    console.log("Selected filters updated:", newValue);
  },
  { deep: true }
);

// Add this method to debug checkbox changes
const handleFilterChange = (sectionId, value, checked) => {
  console.log(`Filter changed: ${sectionId}, value: ${value}, checked: ${checked}`);
};
</script>

<style>
#map {
  height: 500px;
  width: 100%;
}

.leaflet-popup-content-wrapper {
  width: 300px;
}

.z-100 {
  z-index: 9999;
}

.leaflet-container {
  z-index: 1;
}
</style>
