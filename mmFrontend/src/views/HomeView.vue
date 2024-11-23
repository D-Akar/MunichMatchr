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
                <h3 class="sr-only">Categories</h3>
                <ul
                  role="list"
                  class="space-y-4 border-b border-gray-200 pb-6 text-sm font-medium text-gray-900"
                >
                  <li v-for="category in subCategories" :key="category.name">
                    <a :href="category.href">{{ category.name }}</a>
                  </li>
                </ul>

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
                      url="https://tiles.stadiamaps.com/tiles/alidade_smooth_dark/{z}/{x}/{y}{r}.png"
                      layer-type="base"
                      name="Stadia Maps Basemap"
                    ></l-tile-layer>
                    <l-marker
                      v-for="(arcade, index) in filteredArcades"
                      :key="index"
                      :lat-lng="[arcade.lat, arcade.lng]"
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
              </div>
            </div>
          </section>
        </main>
      </div>
    </div>
    <!-- <div
      v-if="showPreferencesPopup"
      class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-100"
    >
      <div class="bg-white shadow sm:rounded-lg">
        <div class="px-4 py-5 sm:p-6">
          <h3 class="text-base font-semibold text-gray-900">
            Tell us more about yourself!
          </h3>
          <div class="mt-2 max-w-xl text-sm text-gray-500">
            <p>Please be sure to select at least one item in each category.</p>
            <div>
              <div class="sm:hidden">
                <label for="tabs" class="sr-only">Select a tab</label>
                
                <select
                  id="tabs"
                  name="tabs"
                  class="block w-full rounded-md border-gray-300 focus:border-indigo-500 focus:ring-indigo-500"
                >
                  <option v-for="tab in tabs" :key="tab.name" :selected="tab.current">
                    {{ tab.name }}
                  </option>
                </select>
              </div>
              <div class="hidden sm:block">
                <nav
                  class="isolate flex divide-x divide-gray-200 rounded-lg shadow"
                  aria-label="Tabs"
                >
                  <a
                    v-for="(tab, tabIdx) in tabs"
                    :key="tab.name"
                    :href="tab.href"
                    :class="[
                      tab.current ? 'text-gray-900' : 'text-gray-500 hover:text-gray-700',
                      tabIdx === 0 ? 'rounded-l-lg' : '',
                      tabIdx === tabs.length - 1 ? 'rounded-r-lg' : '',
                      'group relative min-w-0 flex-1 overflow-hidden bg-white px-4 py-4 text-center text-sm font-medium hover:bg-gray-50 focus:z-10',
                    ]"
                    :aria-current="tab.current ? 'page' : undefined"
                  >
                    <span>{{ tab.name }}</span>
                    <span
                      aria-hidden="true"
                      :class="[
                        tab.current ? 'bg-indigo-500' : 'bg-transparent',
                        'absolute inset-x-0 bottom-0 h-0.5',
                      ]"
                    />
                  </a>
                </nav>
              </div>
            </div>
          </div>
          <div class="mt-5">
            <button
              type="button"
              class="inline-flex items-center rounded-md bg-indigo-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-500"
            >
              Submit
            </button>
          </div>
        </div>
      </div>
    </div> -->
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
import arcades from "@/assets/arcades.json";

const selectedFilters = reactive({
  availability: [],
  interestFields: [],
  languages: [],
  accessibility: [],
});
const filteredArcades = ref(arcades);

let zoom = ref(11);
let center = ref([48.1351, 11.582]);

const filterArcades = () => {
  filteredArcades.value = arcades.filter((arcade) => {
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

const subCategories = [
  { name: "Youth group/outreach program", href: "#" },
  { name: "Retirement home", href: "#" },
  { name: "Care facility", href: "#" },
];
const filters = [
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
    options: [
      { value: "literature", label: "Literature", checked: false },
      { value: "sports", label: "Sports", checked: false },
      { value: "science", label: "Science", checked: true },
      { value: "history", label: "History", checked: false },
      { value: "philosophy", label: "Philosophy", checked: false },
      { value: "travel", label: "Travel", checked: false },
      { value: "cooking", label: "Cooking", checked: false },
    ],
  },
  {
    id: "languages",
    name: "Languages",
    options: [
      { value: "german", label: "German", checked: false },
      { value: "englisch", label: "English", checked: false },
      { value: "turkish", label: "Turkish", checked: false },
      { value: "...", label: "...", checked: false },
    ],
  },
  {
    id: "accessibility",
    name: "Accessibility",
    options: [
      { value: "wheelchairFriendly", label: "Wheelchair accessible", checked: false },
      { value: "publicTransport", label: "Public transportation nearby", checked: false },
    ],
  },
];

const tabs = [
  { name: "My Account", href: "#", current: true },
  { name: "Company", href: "#", current: false },
  { name: "Team Members", href: "#", current: false },
  { name: "Billing", href: "#", current: false },
];

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
  width: 200px;
}

.z-100 {
  z-index: 9999;
}

.leaflet-container {
  z-index: 1;
}
</style>
